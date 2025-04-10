package com.example.demo.controller;

import com.example.demo.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@Import(TestConfig.class)
public class PaisControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PaisService paisService;

    // Seus métodos de teste aqui
}
