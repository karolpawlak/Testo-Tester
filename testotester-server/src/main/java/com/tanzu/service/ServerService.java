package com.tanzu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ServerService {

    @Autowired
    Environment env;

    public String check(){
        return "Success";
    }

    public String[] currentProfile(){
        return env.getActiveProfiles();
    }
}
