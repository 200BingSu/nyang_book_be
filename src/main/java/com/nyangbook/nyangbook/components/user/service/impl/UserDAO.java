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
        String encodedPassword = passwordEncoder.encode(password);

        String sql = "INSERT INTO public.user" +
                " (user_id, password) " +
                "VALUES(?, ?)" +
                "RETURNING user_id, user_name, user_key";
        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(UserVO.class),
                userId, encodedPassword
        );

    }

    // 유저-회원
    public UserVO selectUserAndPet(UserVO userVO){
        String usersKey = userVO.getUser_key();
        String sql = "SELECT u.id, u.email," +
                "COALESCE(" +
                "json_agg(to_jsonb(p)) FILTER (WHERE p.pets_key IS NOT NULL)," +
                "'[]'" +
                ") AS pets" +
                "FROM auth.users u" +
                "LEFT JOIN public.pets p ON p.users_key = u.users_key" +
                "WHERE 1=1" +
                "AND u.users_key = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(UserVO.class),
                usersKey);
    }


}
