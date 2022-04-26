package com.tanzu.service;

import com.tanzu.entity.Mode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClientService {

    public Mode check(){
        // log that
        log.info("Check completed with the result - Client mode: " + Mode.ONLINE);

        return Mode.ONLINE;
    }
}
