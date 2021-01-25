package com.tp.rpg.armors;

public class Plate implements Armor{

    @Override
    public int reduceDamage(int startingDamage) {
        if(startingDamage<=25)
            return 0;
        else
            return startingDamage-25;
    }
}
