package com.fastcampus.jpa.bookmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //ctrl+shit+T로 해당 메서드 테스트 쉽게 생성 가능
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "hello-world";
    }
}
