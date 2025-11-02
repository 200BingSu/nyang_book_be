package com.nyangbook.nyangbook.components.diary.impl;

import com.nyangbook.nyangbook.components.diary.DiaryVO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DiaryDAO {

    private final JdbcTemplate jdbcTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger("NyangBook");


    public DiaryVO insertDairy (DiaryVO diaryVO) {
        StringBuilder builder = new StringBuilder("INSERT INTO public.diary")
                .append("(diary_content, users_key)")
                .append("VALUES(?, ?)")
                .append("RETURNING diary_key, diary_content, users_key ");
        try {
            String sql = builder.toString();
             return jdbcTemplate.queryForObject(
                    sql,
                    new BeanPropertyRowMapper<>(DiaryVO.class),
                    diaryVO.getDiary_content(),
                    diaryVO.getUUID()
                );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
