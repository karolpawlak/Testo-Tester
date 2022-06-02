package com.tanzu.service;

import com.tanzu.entity.Mode;
import com.tanzu.entity.Status;
import com.tanzu.entity.npc.MajorNpc;
import com.tanzu.entity.npc.Npc;
import com.tanzu.repository.NpcRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ServerService {

    @Autowired
    private Environment env;

    @Autowired
    private Status status;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NpcRepository npcRepo;

    @Value("${CLIENT_URL:http://localhost:8081}")
    private String clientUrl;

    public Status check()
    {
        // put server status data
        status.setServerMode(Mode.ONLINE);
        status.setActiveProfile(env.getActiveProfiles());

        // put client status data
        try{
            status.setClientMode(checkClient());
        }
        catch(Exception e){
            status.setClientMode(Mode.UNKNOWN);

            // log that
            log.warn("Liveness probe failed to the client with url " + clientUrl + " with the following exception:", e);
        }

        // log this
        log.info("Check completed with the result - Profile: " + status.getActiveProfile()[0]
                + " Server mode: " + status.getServerMode().toString() + " Client mode: " + status.getClientMode().toString());

        return status;
    }

    public Mode checkClient()
    {
        return restTemplate.getForObject(clientUrl, Mode.class);
    }

    public String createNpc()
    {
        Npc new_npc = new Npc("Toblen", "Stonehill", "Male", "Human", "Merchant");
        MajorNpc new_majornpc = new MajorNpc("Brolly", "Mountainheim", "Male", "Dwarf", "Barbarian");

        String weapon = "Greataxe";
        String armor = "Leather armor";

        new_majornpc.addEquipmentItem(weapon);
        new_majornpc.addEquipmentItem(armor);

        npcRepo.save(new_npc);
        npcRepo.save(new_majornpc);

        return "Created";
    }
}
