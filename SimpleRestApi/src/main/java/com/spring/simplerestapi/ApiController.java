package com.spring.simplerestapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/greet")
    public String greet() {
        return "Hello from Simple REST API (Micro Servce)!\n Regards, Luther";
    }
}
