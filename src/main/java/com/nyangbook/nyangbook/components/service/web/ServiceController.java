package com.nyangbook.nyangbook.components.service.web;

import com.nyangbook.nyangbook.components.service.service.ServiceService;
import com.nyangbook.nyangbook.components.service.service.ServiceVO;
import com.nyangbook.nyangbook.components.user.service.UserService;
import com.nyangbook.nyangbook.components.user.service.UserVO;
import com.nyangbook.nyangbook.components.util.service.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("service")
@RequiredArgsConstructor
public class ServiceController {

     private static final Logger LOGGER = LoggerFactory.getLogger("NyangBook");

     private final ServiceService service;

     @PostMapping("/selectAllServiceWithUserType")
     public ResponseEntity<ResponseDTO> selectAllServiceWithUserType (@RequestBody UserVO user){
         LOGGER.info("[Service] selectAllServiceWithUserType start...");
         try{
             List<ServiceVO> result = service.selectAllServiceWithUserType(user);
             return ResponseEntity.ok().body(new ResponseDTO<>("OK", result));
         } catch (Exception e) {
             return ResponseEntity.badRequest().body(new ResponseDTO("ERROR",e.toString()));
         }
     }
}
