package components.user.service.impl;


import components.user.service.UserVO;
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
        String password = userVO.getPassword();
        String encodedPassword = passwordEncoder.encode(password);

        String sql = "INSERT INTO public.user" +
                " (user_id, password) " +
                "VALUES(?, ?)" +
                "RETURNING";
        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(UserVO.class),
                userVO.getUser_id(),
                encodedPassword
        );

    }
}
