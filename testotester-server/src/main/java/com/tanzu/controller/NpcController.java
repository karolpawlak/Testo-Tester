package com.tanzu.controller;

import com.tanzu.entity.npc.Npc;
import com.tanzu.service.NpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/npc")
public class NpcController {

    @Autowired
    NpcService service;

    @GetMapping("/{npc_id}")
    public ResponseEntity<EntityModel<Npc>> single(@PathVariable Long npc_id) {
        return service.getNpc(npc_id);
    }

    @PostMapping("/generate-basic")
    public ResponseEntity<EntityModel<Npc>> generateNpc(){
        return service.createNpc("Toblen", "Stonehill", "Male", "Human", "Merchant");
    }

    @PostMapping("/generate-major")
    public ResponseEntity<EntityModel<Npc>> generateMajorNpc(){
        return service.createMajorNpc("Zak", "Beshir", "Male", "Human", "Soldier");
    }

    @PostMapping("/generate-hero")
    public ResponseEntity<?> generateHeroNpc(){
        return service.createHeroNpc("Brolly", "Mountainheim", "Male", "Dwarf", "Barbarian");
    }
}
