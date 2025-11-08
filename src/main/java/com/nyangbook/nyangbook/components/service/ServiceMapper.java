package com.nyangbook.nyangbook.components.service;

import com.nyangbook.nyangbook.components.service.service.ServiceVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ServiceMapper {

    List<ServiceVO> selectServiceWithText (ServiceVO serviceVO);
}
