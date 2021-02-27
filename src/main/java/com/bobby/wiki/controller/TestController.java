package com.bobby.wiki.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${test.hello}")
    private String testHello;

    @GetMapping("/hello")
    public String Hello() {
        return "Hello World!" + testHello;
    }

    @PostMapping("hello/post")
    public String HelloPost(String name) {
        return "Hello World" + name;
    }
}
