package com.tanzu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebService {
    @Autowired
    RestTemplate restTemplate;

    public String check(){
        String response = restTemplate.getForObject("http://localhost:8089", String.class);
        return "<h1>Response from backend: " + response + "!</h1>";
    }
}
