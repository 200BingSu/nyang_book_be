package com.nyangbook.nyangbook.components.search.web;


import com.nyangbook.nyangbook.components.search.SearchService;
import com.nyangbook.nyangbook.components.search.SearchVO;
import com.nyangbook.nyangbook.components.service.service.ServiceService;
import com.nyangbook.nyangbook.components.service.service.ServiceVO;
import com.nyangbook.nyangbook.components.util.service.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("search")
@RequiredArgsConstructor
public class SearchController {

    private static final Logger LOGGER = LoggerFactory.getLogger("NyangBook");

    private final ServiceService serviceService;

    private final SearchService searchService;

    @GetMapping("/searchBar")
    public ResponseEntity<ResponseDTO> getSearchWithQuery (
            @RequestParam String query){
        try{
            LOGGER.info("getSearchWithQuery start ...");
            SearchVO searchVO = new SearchVO();
            ServiceVO serviceVO = new ServiceVO();
            serviceVO.setService_name(query);
            List<ServiceVO> serviceVOList = serviceService.selectSerivceWithText(serviceVO);
            LOGGER.info("serviceVOList: {}", serviceVOList);
            searchVO.setServiceVOList(serviceVOList);
            return ResponseEntity.ok().body(new ResponseDTO<>("OK", searchVO));
        } catch (Exception e) {
            LOGGER.error("getSearchWithQuery", e);
            return ResponseEntity.badRequest().body(new ResponseDTO<>("ERROR",e));
        }
    }

    @PostMapping("/dataList")
    public ResponseEntity<ResponseDTO> getDataList (@RequestBody SearchVO searchVO){
        try{
            LOGGER.info("getDataList start...");
            List<Map<String,Object>> dataList = searchService.getDataList(searchVO);
            SearchVO result = new SearchVO();
            result.setDataList(dataList);
            return ResponseEntity.ok().body(new ResponseDTO<>("OK", result));
        } catch (Exception e) {
            LOGGER.error("getDataList ERROR", e);
            return ResponseEntity.badRequest().body(new ResponseDTO<>("ERROR",e));
        }
    }

}
