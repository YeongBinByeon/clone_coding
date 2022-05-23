package com.example.personalstudy.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping(value = "/controller-test1")
    public String getViewTest1(){
        return "test1.html";
    }

    @GetMapping(value = "/controller-test2")
    public String getViewTest2(){
        return "test2.html";
    }

    @GetMapping(value = "/controller-test3")
    public String getViewTest3(){
        return "/m/test3.html";
    }
}
