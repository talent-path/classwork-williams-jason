package com.tp.rpg.armors;

public class Chainmail implements Armor{

    @Override
    public int reduceDamage(int startingDamage) {
        if(startingDamage<=10)
            return 0;
        else
            return startingDamage-10;
    }
}
