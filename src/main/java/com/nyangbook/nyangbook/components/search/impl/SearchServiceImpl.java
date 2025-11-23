package com.nyangbook.nyangbook.components.search.impl;

import com.nyangbook.nyangbook.components.search.SearchMapper;
import com.nyangbook.nyangbook.components.search.SearchService;
import com.nyangbook.nyangbook.components.search.SearchVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    private static final Logger LOGGER = LoggerFactory.getLogger("NyangBook");

    @Autowired
    SearchMapper searchMapper;

    @Override
    public List<Map<String, Object>> getDataList(SearchVO searchVO){
        LOGGER.info("searchVO: {}", searchVO);
       return searchMapper.selectData(searchVO);
    }
}
