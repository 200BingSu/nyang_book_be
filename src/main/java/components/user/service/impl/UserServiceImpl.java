package components.user.service.impl;

import components.user.service.UserService;
import components.user.service.UserVO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserVO loginUser (UserVO userVO) {
        return userVO;
    }
}
