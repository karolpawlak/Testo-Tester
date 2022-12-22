package com.tanzu.service;

import com.tanzu.entity.Mode;
import com.tanzu.entity.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Slf4j
@Service
public class ServerService {

    @Autowired
    private Environment env;

    @Autowired
    private Status status;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${CLIENT_URL:http://localhost:8081}")
    private String clientUrl;

    @Value("${tt-server.message:none}")
    private String configServerMessage;

    public ResponseEntity<Status> check()
    {
        // put server status data
        status.setServerMode(Mode.ONLINE);
        status.setActiveProfile(env.getActiveProfiles());

        // put client status data
        status.setClientMode(checkClient());

        // put config server data
        status.setConfigServerMode(checkConfigServer());

        // log this
        log.info("Check completed with the result - Profile: " + status.getActiveProfile()[0]
                + " Server mode: " + status.getServerMode().toString() + " Client mode: " + status.getClientMode().toString()
                + " Config Server mode: " + status.getConfigServerMode().toString());

        return ResponseEntity.ok(status);
    }

    public Mode checkClient()
    {
        try{
            return restTemplate.getForObject(clientUrl, Mode.class);
        }
        catch(Exception e){
            status.setClientMode(Mode.UNKNOWN);

            // log that
            log.warn("Liveness probe failed to the client with url " + clientUrl + " with the following exception:", e);
            return Mode.UNKNOWN;
        }
    }

    public Mode checkConfigServer()
    {
        if(Objects.equals(configServerMessage, "thisisatestmessage")){
            return Mode.ONLINE;
        }
        else {
            log.warn("Did not receive a configuration value from the Config Server.");
            return Mode.UNKNOWN;
        }
    }


}
