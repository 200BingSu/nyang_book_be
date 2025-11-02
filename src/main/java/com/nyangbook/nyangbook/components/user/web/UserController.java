package com.nyangbook.nyangbook.components.user.web;

import com.nyangbook.nyangbook.components.user.service.UserService;
import com.nyangbook.nyangbook.components.user.service.UserVO;
import com.nyangbook.nyangbook.components.util.service.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger("NyangBook");

    private final UserService userService;


    @PostMapping("/selectUserAndPet")
    public ResponseEntity<ResponseDTO> selectUserAndPet (@RequestBody UserVO userVO){
        LOGGER.info("selectUserAndPet start ...");
        try{
            UserVO result  = userService.selectUserAndPet(userVO);
            return ResponseEntity.ok().body(new ResponseDTO<>("OK", result));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
