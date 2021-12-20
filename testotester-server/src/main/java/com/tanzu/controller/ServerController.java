package com.tanzu.controller;

import com.tanzu.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {
    @Autowired
    ServerService service;

    @GetMapping("/")
    public String get(){
        return service.check();
    }
}
