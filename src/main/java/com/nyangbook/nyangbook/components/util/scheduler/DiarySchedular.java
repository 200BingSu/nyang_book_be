package com.nyangbook.nyangbook.components.util.scheduler;

import com.nyangbook.nyangbook.components.diary.DiaryService;
import com.nyangbook.nyangbook.components.diary.DiaryVO;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
@Slf4j
public class DiarySchedular {

    @Autowired
    private DiaryService diaryService;

     private static final Logger LOGGER = LoggerFactory.getLogger("NyangBook");

     @PostConstruct
    public void init() {
         // 서버 킬 때 바로 실행
//        insertTodayDiary();
    }

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

     @PreDestroy
    public void cleanupExecutor() {
        try {
            LOGGER.info("Shutting down executor service...");
            executor.shutdown();
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

//    @Scheduled(cron = "*/10 * * * * *", zone = "Asia/Seoul")
    public void insertTodayDiary () {
         LOGGER.info("[Schedule] start insertDiary");
        try {
            DiaryVO params = new DiaryVO();
            String now = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            params.setDiary_content(now+" 스케줄러 입력");
            params.setUsers_key("ac19dac6-1d7c-4e09-b463-daf52ba9d7c2");
            DiaryVO result = diaryService.postDiary(params);
            System.out.println("insert: "+result);
            List<DiaryVO> resultList = diaryService.selectDiaryList(new DiaryVO());
            LOGGER.info("현재 결과 : {}", resultList);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}
