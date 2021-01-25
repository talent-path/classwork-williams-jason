package com.tp.rpg;

public abstract class NonPlayerCharacter extends Character {


    public NonPlayerCharacter(){

    }

    @Override
    public int makeChoice() {
        return 1;
    }


    public int reduceDamage(int startingDamage) {
        return 0;
    }


    public int generateDamage() {
        return 0;
    }

}
