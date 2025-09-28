package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 전체 경로 허용
                .allowedOrigins("http://localhost:5173") // 프론트 주소
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메소드
                .allowCredentials(true);
    }
}

