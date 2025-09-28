package components.user.service.impl;

import components.user.service.UserService;
import components.user.service.UserVO;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserVO registerUser (UserVO userVO){
        return registerUser(userVO);
    }

    @Override
    public UserVO loginUser (UserVO userVO) {
        return userVO;
    }
}
