package com.bobby.wiki.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String Hello() {
        return "Hello World!";
    }

    @PostMapping("hello/post")
    public String HelloPost(String name) {
        return "Hello World" + name;
    }
}
