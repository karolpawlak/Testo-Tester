package com.tanzu.controller;

import com.tanzu.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    WebService service;

    @GetMapping("/")
    public String index(){
        return service.check();
    }
}
