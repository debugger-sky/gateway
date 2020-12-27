package com.msa.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello!!";
    }

    @GetMapping("/hi")
    public String hi() {
        return "hi!";
    }

    @GetMapping("/other/1")
    public String other1() {
        return "other1";
    }

    @GetMapping("/other/2")
    public String other2() {
        return "other2";
    }
}
