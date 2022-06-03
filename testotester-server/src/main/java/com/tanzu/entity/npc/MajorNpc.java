package com.tanzu.entity.npc;

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
public class MajorNpc extends Npc {

    private String alignment;

    @ElementCollection
    private List<String> allies;

    @ElementCollection
    private List<String> enemies;

    @ElementCollection
    private List<String> equipment;

    public MajorNpc(String first_name, String last_name, String gender, String race, String profession){
        super(first_name, last_name, gender, race, profession);
        this.allies = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.equipment = new ArrayList<>();

    }

    public void addEquipmentItem(String item){
        equipment.add(item);
    }

    public void addAlly(String ally){
        allies.add(ally);
    }

    public void addEnemy(String enemy){
        enemies.add(enemy);
    }

}
