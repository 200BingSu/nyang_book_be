package com.nyangbook.nyangbook.components.diary.web;

import com.nyangbook.nyangbook.components.diary.DiaryService;
import com.nyangbook.nyangbook.components.diary.DiaryVO;
import com.nyangbook.nyangbook.components.user.service.UserService;
import com.nyangbook.nyangbook.components.user.service.UserVO;
import com.nyangbook.nyangbook.components.util.service.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("diary")
@RequiredArgsConstructor
public class DiaryController {

    private static final Logger LOGGER = LoggerFactory.getLogger("NyangBook");

    private final DiaryService diaryService;


    @PostMapping("/selectList")
    public ResponseEntity<ResponseDTO> selectDiaryList (@RequestBody DiaryVO diaryVO){
        LOGGER.info("diary/selectList start...");
        try{
            List<DiaryVO> resultList = diaryService.selectDiaryList(diaryVO);
            return ResponseEntity.ok().body(new ResponseDTO<>("OK", resultList));
        } catch (Exception e) {
            LOGGER.error("[diary/selectList]{}", e.getMessage());
            return ResponseEntity.badRequest().body(new ResponseDTO<>("ERROR", new ArrayList<>()));
        }
    }
}
