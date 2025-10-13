package com.nyangbook.nyangbook.components.user.service.impl;

import com.nyangbook.nyangbook.components.user.service.UserService;
import com.nyangbook.nyangbook.components.user.service.UserVO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger("NyangBook");
//    private final PasswordEncoder passwordEncoder;


    @Override
    public UserVO selectUserAndPet (UserVO userVO) {
        try{
            return userDAO.selectUserAndPet(userVO);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return new UserVO();
        }
    }
}
