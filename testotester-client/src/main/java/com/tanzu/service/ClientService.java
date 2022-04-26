package com.tanzu.service;

import com.tanzu.entity.Mode;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    public Mode check(){
        return Mode.ONLINE;
    }
}
