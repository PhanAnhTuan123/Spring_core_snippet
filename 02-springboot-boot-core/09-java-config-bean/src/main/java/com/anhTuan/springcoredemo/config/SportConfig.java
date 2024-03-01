package com.anhTuan.springcoredemo.config;

import com.anhTuan.springcoredemo.common.Coach;
import com.anhTuan.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
