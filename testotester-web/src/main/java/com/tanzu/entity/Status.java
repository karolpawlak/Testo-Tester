package com.tanzu.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Status {
    private String[] activeProfile;
    private Mode serverMode = Mode.UNKNOWN;
    private Mode clientMode = Mode.UNKNOWN;
}
