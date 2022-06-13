package com.tanzu.entity.npc;

import com.tanzu.entity.Alignment;
import com.tanzu.entity.race.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MajorNpc extends Npc implements Dwarf, Elf, Gnome, Halfling, Human {

    // Abilities
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    private Alignment alignment;

    @ElementCollection
    private List<String> allies;

    @ElementCollection
    private List<String> enemies;

    public MajorNpc(String first_name, String last_name, String gender, String race, String profession){
        super(first_name, last_name, gender, race, profession);
        this.allies = new ArrayList<>();
        this.enemies = new ArrayList<>();
    }

    @Override
    public void show(){
        switch (super.race.toLowerCase()) {
            case "dwarf":
                Dwarf.super.show();
                break;
            case "elf":
                Elf.super.show();
                break;
            case "gnome":
                Gnome.super.show();
                break;
            case "halfling":
                Halfling.super.show();
                break;
            case "human":
                Human.super.show();
                break;
            default:
                throw new IllegalArgumentException("No such race.");
        }
    }

    public void addAlly(String ally){
        allies.add(ally);
    }

    public void addEnemy(String enemy){
        enemies.add(enemy);
    }

}
