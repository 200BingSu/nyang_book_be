package com.nyangbook.nyangbook.components.user.service.impl;


import com.nyangbook.nyangbook.components.user.service.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;

    private final PasswordEncoder passwordEncoder;



    // 유저 정보
    public UserVO selectUserAndPet(UserVO userVO){
        String id = userVO.getId();
        UUID uuiUserKey = UUID.fromString(id);
        String sql =
            "SELECT u.*, uu.uut_key , ut.user_type " +
                    "FROM auth.users u " +
                    "LEFT JOIN public.user_ut uu ON uu.user_key  = u.id " +
                    "LEFT JOIN public.users_type ut ON uu.ut_key  = ut.ut_key " +
                    "WHERE u.id=?";

        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(UserVO.class),
                uuiUserKey);
    }



}
