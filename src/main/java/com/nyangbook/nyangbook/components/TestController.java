package com.nyangbook.nyangbook.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger("NyangBook");

    @GetMapping("/api/test")
    public ResponseEntity<String> test() {
        LOGGER.info("API /api/test 호출됨");
        return ResponseEntity.ok("ok");
    }
}
