package com.tanzu.service;

import com.tanzu.entity.Mode;
import com.tanzu.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public Status check(){
        status.setServerMode(Mode.ONLINE);
        status.setActiveProfiles(env.getActiveProfiles());

        try{
            status.setClientMode(checkClient());
        }
        catch(Exception e){
            status.setClientMode(Mode.UNKNOWN);

            // log that
            System.out.println(e);
        }

        return status;
    }

    public Mode checkClient()
    {
        Mode response = restTemplate.getForObject(clientUrl, Mode.class);
        System.out.println(response);
        return response;
    }
}
