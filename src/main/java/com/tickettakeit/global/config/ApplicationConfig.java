package com.tickettakeit.global.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import({DBConfig.class, SecurityConfig.class})
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"com.tickettakeit.domain.*.dao",
        "com.tickettakeit.domain.*.service"
        ,"com.tickettakeit.global.*"})
public class ApplicationConfig {
}
