package com.tanzu.service;

import com.tanzu.assember.NpcAssembler;
import com.tanzu.entity.npc.MajorNpc;
import com.tanzu.entity.npc.Npc;
import com.tanzu.handlers.NpcNotFoundException;
import com.tanzu.repository.NpcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NpcService {

    @Autowired
    private NpcRepository npcRepo;

    @Autowired
    private NpcAssembler npcAssembler;

    public ResponseEntity<EntityModel<Npc>> createNpc(String first_name, String last_name, String gender, String race, String profession)
    {
        Npc new_npc = new Npc(first_name, last_name, gender, race, profession);
        npcRepo.save(new_npc);

        return ResponseEntity
                .created(npcAssembler.toURI(new_npc))
                .body(npcAssembler.toModel(new_npc));
    }

    public ResponseEntity<EntityModel<Npc>> createMajorNpc(String first_name, String last_name, String gender, String race, String profession)
    {
        MajorNpc new_major_npc = new MajorNpc(first_name, last_name, gender, race, profession);
        npcRepo.save(new_major_npc);

        return ResponseEntity
                .created(npcAssembler.toURI(new_major_npc))
                .body(npcAssembler.toModel(new_major_npc));
    }

    public ResponseEntity<EntityModel<Npc>> getNpc(Long npc_id) {
        Npc npc = npcRepo.findById(npc_id).orElseThrow(() -> new NpcNotFoundException(npc_id));

        return ResponseEntity.status(HttpStatus.OK).body(npcAssembler.toModel(npc));
    }

    public ResponseEntity<?> createHeroNpc(String first_name, String last_name, String gender, String race, String profession) {
        return ResponseEntity.noContent().build();
    }
}
