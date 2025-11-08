package com.nyangbook.nyangbook.components.service.service;

import com.nyangbook.nyangbook.components.user.service.UserVO;

import java.util.List;

public interface ServiceService {
    List<ServiceVO> selectAllServiceWithUserType (UserVO userVO);
    List<ServiceVO> selectSerivceWithText (ServiceVO serviceVO);
}
