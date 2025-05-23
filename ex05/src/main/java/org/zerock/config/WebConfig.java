package org.zerock.config; // ← 예지님 패키지에 맞게 수정해주세요!

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 브라우저에서 /upload/** 요청 시 → 실제 C:/upload/ 폴더에서 파일을 찾아 응답
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:///C:/upload/")
                .setCachePeriod(3600); // 캐시 (선택사항)
    }
}