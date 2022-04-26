package com.tanzu.controller;

import com.tanzu.entity.Mode;
import com.tanzu.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    ClientService service;

    @GetMapping("/")
    public Mode get(){
        return service.check();
    }
}
