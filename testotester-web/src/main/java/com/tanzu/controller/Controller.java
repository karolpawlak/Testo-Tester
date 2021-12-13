package com.tanzu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    public String index(){
        String response = restTemplate.getForObject("http://localhost:8089", String.class);
        return "<h1>Response from backend: " + response + "!</h1>";
    }
}
