package com.tanzu.entity.npc;

import com.tanzu.entity.Alignment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MajorNpc extends Npc {

    // Abilities
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    // Other
    private Alignment alignment;

    @ElementCollection
    private List<String> equipment;

    // Constructor
    public MajorNpc(String first_name, String last_name, String gender, String race, String profession){
        super(first_name, last_name, gender, race, profession);
        equipment = new ArrayList<>();
        alignment = generateAlignment();
        assignAbilities();
    }

    // Randomizer Class - ThreadLocalRandom has a Random instance per thread and safeguards against contention.
    static class RandomTools {
        public static int randomValue(int size) {
            return ThreadLocalRandom.current().nextInt(0, size);
        }

        public static int randomAbility() {
            int no_of_dice = 4;
            int d6 = 6;
            int[] roll_arr = new int[no_of_dice];

            // Roll a number of dice and store it in a roll_arr array
            for(int i = 0; i < no_of_dice; i++)
            {
                int roll_d6 = ThreadLocalRandom.current().nextInt(1, d6 + 1);
                roll_arr[i] = roll_d6;
            }

            // Sort the array lowest to highest
            Arrays.sort(roll_arr);
            int res = 0;

            // Get a sum of dice rolls and discard the lowest. Start i with 1, thus eliminating the result at index 0
            for(int i = 1; i < no_of_dice; i++)
            {
                res += roll_arr[i];
            }

            return res;
        }
    }


    public Alignment generateAlignment(){
        // Store alignments in an array
        Alignment[] alignment_arr = Alignment.values();

        // Pick a random alignment from the array and return it
        int arr_size = alignment_arr.length;
        int random_alignment = RandomTools.randomValue(arr_size);

        return alignment_arr[random_alignment];
    }


    public int[] generateAbilities(){
        int no_of_rolls = 3;
        int no_of_abilities = 6;
        int best_roll_sum = 0;
        int best_roll_pos = 0;
        int[] ability_arr = new int[no_of_abilities];
        int[][] roll_arr = new int[no_of_rolls][no_of_abilities];

        // Perform a number of rolls of all the abilities and store in a two-dimensional array
        for(int i = 0; i < no_of_rolls; i++)
        {
            int[] new_ability_arr = new int[no_of_abilities];
            int roll_sum = 0;
            for(int j = 0; j < no_of_abilities; j++)
            {
                new_ability_arr[j] = RandomTools.randomAbility();
                roll_sum += new_ability_arr[j];
            }

            // Save the position of the best roll
            if(roll_sum > best_roll_sum) {
                best_roll_pos = i;
            }

            roll_arr[i] = new_ability_arr;
        }

        // Pick the ability array with highest values
        ability_arr = roll_arr[best_roll_pos];

        return ability_arr;
    }

    public void assignAbilities() {
        int[] abilities = generateAbilities();
        strength = abilities[0];
        dexterity = abilities[1];
        constitution = abilities[2];
        intelligence = abilities[3];
        wisdom = abilities[4];
        charisma = abilities[5];
    }

    public void addEquipment(String item){
        equipment.add(item);
    }
}

