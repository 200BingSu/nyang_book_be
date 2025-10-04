package com.nyangbook.nyangbook.components.user.service.impl;


import com.nyangbook.nyangbook.components.user.service.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;

    private final PasswordEncoder passwordEncoder;

    public UserVO registerUser(UserVO userVO){
        String userId = userVO.getUser_id();
        String password = userVO.getPassword();
        System.out.println("userId"+ userId);
//        System.out.println("passwor"+ password);
        String encodedPassword = passwordEncoder.encode(password);

        String sql = "INSERT INTO public.user" +
                " (user_id, password) " +
                "VALUES(?, ?)" +
                "RETURNING user_id, user_name";
        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(UserVO.class),
                userId, encodedPassword
        );

    }
}
