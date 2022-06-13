package com.tanzu.entity.race;

public interface Human {
    default void show()
    {
        System.out.println("I'm a human");
    }
}
