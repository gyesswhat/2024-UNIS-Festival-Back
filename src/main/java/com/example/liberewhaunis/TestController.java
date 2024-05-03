package com.example.liberewhaunis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String helloworld() {
        return "Hello, world! ";
    }
}
