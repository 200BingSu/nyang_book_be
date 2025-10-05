package com.nyangbook.nyangbook.components.service.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nyangbook.nyangbook.components.service.service.ServiceVO;
import com.nyangbook.nyangbook.components.user.service.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Repository
@RequiredArgsConstructor
public class ServiceDAO {

    private final JdbcTemplate jdbcTemplate;

    // 유저 권한 따른 전체 서비스
    public List<ServiceVO> selectAllServiceWithUserType(UserVO userVO) {
        String userType = userVO.getUser_type();

        String sql =
            "SELECT " +
            "    s.*, " +
            "    COALESCE( " +
            "        json_agg(DISTINCT to_jsonb(sr)) FILTER (WHERE sr.parent_service_key IS NOT NULL), " +
            "        '[]' " +
            "    ) AS childService " +
            "FROM public.service s " +
            "LEFT JOIN public.service_relations sr ON s.service_key = sr.parent_service_key " +
            "LEFT JOIN public.service_ut su ON su.service_key = s.service_key " +
            "LEFT JOIN public.users_type ut ON su.ut_key = ut.ut_key ";

        List<Object> params = new ArrayList<>();
        if (userType != null && !userType.isEmpty()) {
            sql += "WHERE ut.user_type = ? ";
            params.add(userType);
        }

        sql += "GROUP BY s.service_key";

        return jdbcTemplate.query(sql, params.toArray(), (rs, rowNum) -> {
            ServiceVO vo = new ServiceVO();
            vo.setService_key((int) rs.getLong("service_key"));
            vo.setService_name(rs.getString("service_name"));
            vo.setService_en(rs.getString("service_en"));
            vo.setService_type(rs.getString("service_type"));
            // JSON 컬럼 처리
            vo.setChildService(jsonToList(rs.getString("childService")));
            return vo;
        });
    }

    // JSON 문자열 → List<Map<String,Object>> 변환
    private List<Map<String, Object>> jsonToList(String json) {
        if (json == null || json.isBlank()) return new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, new TypeReference<List<Map<String, Object>>>(){});
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
