package com.nyangbook.nyangbook.components.search;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SearchMapper {
    List<Map<String,Object>> selectData(SearchVO searchVO);
}
