package com.nyangbook.nyangbook.components.user.service.impl;

import com.nyangbook.nyangbook.components.user.service.UserService;
import com.nyangbook.nyangbook.components.user.service.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

//    private final PasswordEncoder passwordEncoder;

    @Override
    public UserVO registerUser (UserVO userVO){
        return userDAO.registerUser(userVO);
    }

    @Override
    public UserVO loginUser (UserVO userVO) {
        return userVO;
    }
}
