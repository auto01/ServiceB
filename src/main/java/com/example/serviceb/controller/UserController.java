package com.example.serviceb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/callA")
    public String callA(){

        System.out.println("Inside call A controller at service B");

        String response=restTemplate.getForObject("http://SERVICEA/helloA",String.class);
        System.out.println("response:"+response);
        return response;
    }
}
