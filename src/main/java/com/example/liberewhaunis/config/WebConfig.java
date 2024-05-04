package com.example.liberewhaunis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 경로에 대해 CORS 허용 설정
                .allowedOrigins("https://2024-unis-festival-front.vercel.app/", "http://127.0.0.1:5173/"); // 허용할 origin 목록
    }
}
