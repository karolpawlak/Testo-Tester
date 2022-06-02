package com.tanzu.entity.npc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // advantage of polymorphic query performance since only one table needs to be accessed when querying parent entity
@Table(name = "npc")
public class Npc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NPC_ID")
    protected Long npcID;
    protected String first_name;
    protected String last_name;
    protected String gender;
    protected String race;
    protected String profession;

    public Npc(String first_name, String last_name, String gender, String race, String profession){
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.race = race;
        this.profession = profession;
    }

    @Override
    public String toString(){
        return "First name: " + this.first_name +
                "\nLast name: " + this.last_name +
                "\nGender: " + this.gender +
                "\nRace: " + this.race +
                "\nProfession: " + this.profession;
    }

}
