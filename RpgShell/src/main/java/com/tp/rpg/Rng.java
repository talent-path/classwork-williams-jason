package com.tp.rpg;

import java.util.Random;

public class Rng {
    static Random rng = new Random();

    public static int randInt(int incMin, int incMax){

        int rand = incMin + rng.nextInt((incMax - incMin)+1);

        return rand;
    }

    public static double randDouble(double incMin, double incMax){

        double rand = incMin + rng.nextDouble() * (incMax - incMin);

        return rand;
    }

    public static boolean coinFlip(){
        return rng.nextBoolean();
    }
}
