package com.tanzu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${SERVER_URL:http://localhost:8089}")
    private String serverUrl;

    public String check(){
        String response = restTemplate.getForObject(serverUrl, String.class);
        return "<h1>Response from backend: " + response + "!</h1>";
    }
}
