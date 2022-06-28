package com.tanzu.service;

import com.tanzu.entity.Alignment;
import com.tanzu.entity.npc.MajorNpc;
import com.tanzu.entity.npc.Npc;
import com.tanzu.factory.MonsterFactory;
import com.tanzu.repository.NpcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NpcService {

    @Autowired
    private NpcRepository npcRepo;

    public String createNpc(String first_name, String last_name, String gender, String race, String profession)
    {
        Npc new_npc = new Npc(first_name, last_name, gender, race, profession);

        npcRepo.save(new_npc);

        return "Created NPC";
    }

    public String createMajorNpc(String first_name, String last_name, String gender, String race, String profession)
    {
        MajorNpc new_major_npc = new MajorNpc(first_name, last_name, gender, race, profession);
        new_major_npc.show();
        new_major_npc.setAlignment(Alignment.LAWFUL_GOOD);

        npcRepo.save(new_major_npc);

        return "Created Major NPC";
    }
}
