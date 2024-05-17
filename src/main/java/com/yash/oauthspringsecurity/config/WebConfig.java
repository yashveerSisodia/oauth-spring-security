package com.yash.oauthspringsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    private static final String HttpHeaders_XRequestedWith = "X-Requested-With";

    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods(HttpMethod.GET.name(),
                                HttpMethod.POST.name(),
                                HttpMethod.OPTIONS.name(),
                                HttpMethod.PUT.name(),
                                HttpMethod.PATCH.name(),
                                HttpMethod.DELETE.name())
                        .allowedHeaders(HttpHeaders.CONTENT_TYPE,
                                HttpHeaders.AUTHORIZATION,
                                HttpHeaders.CACHE_CONTROL,
                                HttpHeaders.PRAGMA,
                                HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,
                                HttpHeaders_XRequestedWith)
                        .maxAge(3600L); // one hour

            }
        };
    }
}
