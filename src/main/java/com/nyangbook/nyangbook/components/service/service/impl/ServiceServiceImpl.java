package com.nyangbook.nyangbook.components.service.service.impl;

import com.nyangbook.nyangbook.components.service.ServiceMapper;
import com.nyangbook.nyangbook.components.service.service.ServiceService;
import com.nyangbook.nyangbook.components.service.service.ServiceVO;
import com.nyangbook.nyangbook.components.user.service.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceMapper serviceMapper;

    @Autowired
    ServiceDAO serviceDAO;

    @Override
    public List<ServiceVO> selectAllServiceWithUserType (UserVO userVO){
        return serviceDAO.selectAllServiceWithUserType(userVO);
    }

    @Override
    public List<ServiceVO> selectSerivceWithText (ServiceVO serviceVO){ return serviceMapper.selectServiceWithText(serviceVO);};
}
