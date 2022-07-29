package com.tanzu.handlers;

public class NpcNotFoundException extends RuntimeException {
    public NpcNotFoundException(Long id) {
        super("Could not find an NPC with ID: " + id.toString());
    }
}
