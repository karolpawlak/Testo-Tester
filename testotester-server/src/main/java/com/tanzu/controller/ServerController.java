package com.tanzu.controller;

import com.tanzu.entity.Status;
import com.tanzu.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {
    @Autowired
    ServerService service;

    @GetMapping("/")
    public Status get(){
        return service.check();
    }

    @GetMapping("/generate-npc")
    public String generateNpc(){
        return service.createNpc("Toblen", "Stonehill", "Male", "Human", "Merchant");
    }

    @GetMapping("/generate-major-npc")
    public String generateMajorNpc(){
        return service.createMajorNpc("Brolly", "Mountainheim", "Male", "Dwarf", "Barbarian");
    }
}
