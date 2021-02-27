package com.bobby.wiki.controller;

import com.bobby.wiki.domain.Test;
import com.bobby.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private TestService testService;

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

    @GetMapping("/test/list")
    public List<Test> list() {
        return testService.list();
    }
}
