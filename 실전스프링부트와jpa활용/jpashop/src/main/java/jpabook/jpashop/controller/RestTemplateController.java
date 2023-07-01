package jpabook.jpashop.controller;

import jpabook.jpashop.api.MemberApiController;
import jpabook.jpashop.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment environment;

    @GetMapping("/get1")
    public ResponseEntity<List<Member>> getMethod1(){
        String testUrl = environment.getProperty("rest-template.get1");

        ResponseEntity<List<Member>> members =
                restTemplate.exchange(testUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Member>>() {
        });

        return members;
    }

    @GetMapping("/get2")
    public ResponseEntity<MemberApiController.Result<List<MemberApiController.MemberDto>>> getMethod2(){
        String testUrl = environment.getProperty("rest-template.get2");

        ResponseEntity<MemberApiController.Result<List<MemberApiController.MemberDto>>> members =
        restTemplate.exchange(testUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<MemberApiController.Result<List<MemberApiController.MemberDto>>>() {
                });

        return members;
        //MemberApiController.Result<List<MemberApiController.MemberDto>>
    }


}