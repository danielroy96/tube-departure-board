package com.droy.tubedepartureboard;

import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    public static final String STOP_POINT_PREDICTION = "stopPointPrediction";
//
//    @Bean
//    public Cache stopPointPrediction() {
//    }


}
