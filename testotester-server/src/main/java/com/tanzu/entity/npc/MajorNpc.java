package com.tanzu.entity.npc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
        super.first_name = first_name;
        super.last_name = last_name;
        super.gender = gender;
        super.race = race;
        super.profession = profession;
        this.allies = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.equipment = new ArrayList<>();

    }

    public void addEquipmentItem(String item){
        equipment.add(item);
    }

}
