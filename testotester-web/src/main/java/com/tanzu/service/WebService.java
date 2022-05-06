package com.tanzu.service;

import com.tanzu.entity.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class WebService {

    @Autowired
    private Status status;

    @Autowired
    RestTemplate restTemplate;

    // server url - load env variable or use localhost as default
    @Value("${SERVER_URL:http://localhost:8089}")
    private String serverUrl;

    public String check(){
        try{
            status = restTemplate.getForObject(serverUrl, Status.class);
        }
        catch(Exception e){
            log.warn("Liveness probe failed to the server with url " + serverUrl + " with the following exception:", e);
        }
        return "<h1>Current status of the server: " + status.getServerMode() + "</h1>" +
               "<h1>Current status of the client: " + status.getClientMode() + "</h1>";
    }
}
