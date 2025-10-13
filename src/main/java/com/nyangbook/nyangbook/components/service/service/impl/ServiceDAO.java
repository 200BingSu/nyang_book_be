package com.nyangbook.nyangbook.components.service.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nyangbook.nyangbook.components.service.service.ServiceVO;
import com.nyangbook.nyangbook.components.user.service.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
        "SELECT s.*, " +
        "COALESCE( " +
        "   ( " +
        "       SELECT json_agg(js) " +
        "       FROM ( " +
        "           SELECT DISTINCT jsonb_build_object( " +
        "               'service_key', cs.service_key, " +
        "               'service_name', cs.service_name, " +
        "               'service_type', cs.service_type, " +
        "               'service_en', cs.service_en " +
        "           ) AS js " +
        "           FROM public.service_relations sr " +
        "           JOIN public.service cs ON sr.child_service_key = cs.service_key " +
        "           WHERE sr.parent_service_key = s.service_key " +
        "       ) sub " +
        "   ), " +
        "   '[]' " +
        ") AS childServiceJson " +
        "FROM public.service s " +
        "LEFT JOIN public.service_ut su ON su.service_key = s.service_key " +
        "WHERE (s.service_type = 'home' OR s.service_type = 'main_menu')" +
        "GROUP BY s.service_key " +
        "ORDER BY index";


        try{
            List<ServiceVO> services = jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(ServiceVO.class)
            );
            services.forEach(service -> {
                service.setChildService(jsonToList(service.getChildServiceJson()));
            });
            return services;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<ServiceVO>();
        }

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
