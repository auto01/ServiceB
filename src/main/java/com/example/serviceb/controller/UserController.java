package com.example.serviceb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/serviceB")
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${PORT_VAL}")
    private String port_val;

    @GetMapping("/callA")
    public String callA(){

        System.out.println("Inside call A controller at service B");

        String response=restTemplate.getForObject("http://SERVICEA/serviceA/hello",String.class);
        System.out.println("response:"+response);
        return response;
    }

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("inside hello B controller of service B");
        System.out.println("hello B.....");
        return "hello B from port:"+port_val;
    }
}
