package com.tp.diceroller.services;

import java.util.Random;

public class Rng {

    static Random rng = new Random();


    public static int rollDice(int sidesOfDice){
        return rng.nextInt(sidesOfDice)+1;

    }
}
