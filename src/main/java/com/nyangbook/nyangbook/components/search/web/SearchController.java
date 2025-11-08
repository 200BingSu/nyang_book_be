package com.nyangbook.nyangbook.components.search.web;


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

@RestController
@RequestMapping("search")
@RequiredArgsConstructor
public class SearchController {

    private static final Logger LOGGER = LoggerFactory.getLogger("NyangBook");

    private final ServiceService serviceService;

    @GetMapping("/content")
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

}
