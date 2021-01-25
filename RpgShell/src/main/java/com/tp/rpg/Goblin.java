package com.tp.rpg;
import com.tp.rpg.armors.*;
import com.tp.rpg.weapons.*;

//goblins always attack?
public class Goblin extends NonPlayerCharacter {


    public Goblin(){
        super.currentWeapon = new Spear();
        super.currentArmor = new Shirt();

    }

    public void makeChoice(Character pc) {
        System.out.println("The Goblin attacks");
        this.attack(pc);
    }


    public int generateDamage(){

        return currentWeapon.generateDamage();
    }

}
