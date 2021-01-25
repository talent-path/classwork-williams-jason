package com.tp.rpg;

import java.util.Scanner;

public class PlayerCharacter extends Character {
    //use scanner here to get something from the user
    Scanner scan = new Scanner(System.in);
    String name = "Bob";

    public PlayerCharacter(){

    }

    public PlayerCharacter setUpPlayerCharacter(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter you name");
        PlayerCharacter pc = new PlayerCharacter();
        pc.name = scan.nextLine();
        super.pickWeapon();
        super.pickArmor();
        return pc;
    }

    @Override
    public int makeChoice() {
        int choice;
        System.out.println();
        choice = Console.readInt("Would you liked to \n 1: attack \n 2: defend",1,2);
        return choice;
    }
}
