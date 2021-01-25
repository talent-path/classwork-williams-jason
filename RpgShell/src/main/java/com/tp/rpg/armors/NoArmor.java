package com.tp.rpg.armors;

public class NoArmor implements Armor{

    @Override
    public int reduceDamage(int incomingDamage){
        return incomingDamage;
    }

}
