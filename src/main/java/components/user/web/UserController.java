package components.user.web;

import components.user.service.UserService;
import components.user.service.UserVO;
import components.util.service.ResponseDTO;
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

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> registerUser (@RequestBody UserVO userVO){
        LOGGER.info("registerUser start ...");
        try{
            UserVO result = userService.registerUser(userVO);
            return ResponseEntity.ok().body(new ResponseDTO("OK", result));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseDTO(false,e.toString()));
        }
    }
}
