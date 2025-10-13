package com.nyangbook.nyangbook.components.diary.impl;

import com.nyangbook.nyangbook.components.diary.DiaryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@RequiredArgsConstructor
public class DiaryDAO {

    private final JdbcTemplate jdbcTemplate;

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
