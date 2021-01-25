package com.tp.rpg.armors;

public class Shirt implements Armor {

    @Override
    public int reduceDamage(int startingDamage) {
        if(startingDamage<=5)
            return 0;
        else
            return startingDamage - 5 ;
    }
}
