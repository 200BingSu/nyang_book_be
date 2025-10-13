package com.nyangbook.nyangbook.components.service.service.impl;

import com.nyangbook.nyangbook.components.service.service.ServiceService;
import com.nyangbook.nyangbook.components.service.service.ServiceVO;
import com.nyangbook.nyangbook.components.user.service.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    ServiceDAO serviceDAO;

    @Override
    public List<ServiceVO> selectAllServiceWithUserType (UserVO userVO){
        return serviceDAO.selectAllServiceWithUserType(userVO);
    }
}
