package com.example.demo.controller;

import com.example.demo.service.PaisService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.mockito.Mockito;

@TestConfiguration
public class TestConfig {

    @Bean
    public PaisService paisService() {
        return Mockito.mock(PaisService.class);
    }
}
