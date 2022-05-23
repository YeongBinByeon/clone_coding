package com.example.personalstudy.controller.test;

import com.example.personalstudy.dto.test.TestDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestRestController {

    @GetMapping(value = "/")
    public String getMapping(){
        return "getMapping";
    }

    @GetMapping(value = "/test")
    public String getMapping1(@RequestParam String name, @RequestParam int age){
        return name + " " + age;
    }

    @GetMapping(value = "/test2")
    public String getMapping2(@RequestParam(name = "nickname") String name, @RequestParam int age){
        return name + " " + age;
    }

    @GetMapping(value = "/test3/{id}")
    public String getMapping3(@PathVariable(name = "id") int age){
        return ""+age;
    }

    @PostMapping("/")
    public String postMapping(){
        return "postMapping";
    }

    @PostMapping("/test")
    public String postMapping1(@RequestBody TestDto testDto){
        System.out.println("testDto = " + testDto);
        return testDto.toString();
    }

    @PutMapping("")
    public String putMapping(){
        return "put mapping";
    }

    @DeleteMapping
    public String deleteMapping(){
        return "delete Mapping";
    }
}
