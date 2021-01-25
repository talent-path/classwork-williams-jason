package com.tp.rpg;


import com.tp.rpg.weapons.*;
import com.tp.rpg.armors.*;

//TODO:
//      add a concept of hitpoints
//      add a concept of armor (or maybe multiple pieces of armor)
//      add a concept of a weapon (or maybe multiple weapons)
//Stretch goals:
//      add a potion class/interface that the character can drink instead of attacking
//      let the character "disarm" the opponent instead of attacking
//          base this on the weapons used?
//      let the character choose to "block" or "defend"
//          could stun the opponent if they attack?
//          could give us TWO attacks on the next round?
public abstract class Character implements Chooser{

    int health = 100;

    //TODO: add fields for armor(s) and weapon(s)

    Weapon currentWeapon;
    Armor currentArmor;

    public void pickWeapon(){
        int choice = Console.readInt("Pick Your Weapon! \n 1: Spear \n 2: short sword \n 3: long sword \n 4: unarmed \n",1,4);
        switch (choice) {
            case 1:
                this.currentWeapon = new Spear();
                break;
            case 2:
                this.currentWeapon = new ShortSword();
                break;
            case 3:
                this.currentWeapon = new LongSword();
                break;
            case 4:
                this.currentWeapon = new Fist();
        }
    }

    public void pickArmor(){
        int choice = Console.readInt("Pick Your armor! \n 1: shirt \n 2: chainmail \n 3: plate \n 4: no armor \n",1,4);
        switch (choice) {
            case 1:
                this.currentArmor = new Shirt();
                break;
            case 2:
                this.currentArmor = new Chainmail();
                break;
            case 3:
                this.currentArmor = new Plate();
                break;
            case 4:
                this.currentArmor = new NoArmor();
        }
    }

    public void attack( Character defender ){
        defender.health -= defender.currentArmor.reduceDamage(this.currentWeapon.generateDamage());
    }

    public boolean isAlive(){
        if(health > 0)
            return true;
        else
            return false;
    }

}
