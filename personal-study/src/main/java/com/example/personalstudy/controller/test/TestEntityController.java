package com.example.personalstudy.controller.test;

import com.example.personalstudy.entity.TestEntity;
import com.example.personalstudy.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test-entity")
public class TestEntityController {

    private final TestRepository testRepository;

    @Autowired
    TestEntityController(TestRepository testRepository){
        this.testRepository = testRepository;
    }

    @GetMapping(value = "save-entity")
    public String saveTenEntity(){
        for (int i=1;i<=10;i++){
            TestEntity testEntity = new TestEntity();
            testEntity.setAge(i+1);
            testEntity.setName("test"+i);

            testRepository.save(testEntity);
        }
        return "save entity success";
    }


    @GetMapping(value = "/{age}")
    public ResponseEntity<TestEntity> findEntity(@PathVariable int age){
        TestEntity testEntity = testRepository.findByAge(age);
        return ResponseEntity.ok(testEntity);
    }

    @GetMapping(value = "/jpql/{age}")
    public ResponseEntity<List<TestEntity>> findEntityJpql(@PathVariable int age){
        List<TestEntity> testEntityList = testRepository.findEntityLargeThanAge(age);
        return ResponseEntity.ok(testEntityList);
    }

    @GetMapping(value = "/native/{age}")
    public ResponseEntity<List<TestEntity>> findEntityNative(@PathVariable int age){
        List<TestEntity> testEntityList = testRepository.findEntityLargeThanAgeNativeQuery(age);
        return ResponseEntity.ok(testEntityList);
    }
}
