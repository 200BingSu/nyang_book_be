package com.nyangbook.nyangbook.components.product.web;

import com.nyangbook.nyangbook.components.product.service.ProductService;
import com.nyangbook.nyangbook.components.product.service.ProductVO;
import com.nyangbook.nyangbook.components.search.SearchService;
import com.nyangbook.nyangbook.components.service.service.ServiceService;
import com.nyangbook.nyangbook.components.service.service.ServiceVO;
import com.nyangbook.nyangbook.components.user.service.UserService;
import com.nyangbook.nyangbook.components.user.service.UserVO;
import com.nyangbook.nyangbook.components.util.service.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger("NyangBook");

    private final ProductService service;

    @PostMapping("/selectProduct")
    public ResponseEntity<ResponseDTO> selectProduct (){
         LOGGER.info("[Service] selectAllServiceWithUserType start...");
         try{
             List<ProductVO> result = service.selectList(new ProductVO());
             return ResponseEntity.ok().body(new ResponseDTO<>("OK", result));
         } catch (Exception e) {
             return ResponseEntity.badRequest().body(new ResponseDTO<>("ERROR",e.toString()));
         }
     }

}
