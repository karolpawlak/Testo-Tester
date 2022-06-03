package com.tanzu.factory;

import com.tanzu.entity.npc.MajorNpc;
import com.tanzu.entity.npc.Npc;
import org.springframework.stereotype.Component;

@Component
public class MonsterFactory {

    public Object createNpc(String type, String first_name, String last_name, String gender, String race, String profession){

        Object new_npc = switch (type.toLowerCase()) {
            case "npc" -> new Npc(first_name, last_name, gender, race, profession);
            case "major_npc" -> new MajorNpc(first_name, last_name, gender, race, profession);
            default -> throw new IllegalArgumentException("No such NPC type.");
        };

        return new_npc;
    }
}
