package com.tp.rpg;


import java.util.Scanner;

public class Application {
    public static void main(String[] args) {


        PlayerCharacter pc = new PlayerCharacter();
        pc.setUpPlayerCharacter();
        NonPlayerCharacter goblin = new Goblin();

        goblin.attack(pc);



//        while( pc.isAlive() ){
//            NonPlayerCharacter enemy = setUpEnemy();
//
//            battle( pc, enemy );
//
//
//        }
//
//        gameOverScreen();

    }

    //walk the user through setting up their character
    private static PlayerCharacter setUpPlayer() {
        throw new UnsupportedOperationException();
    }

    //create some NPC object (with armor & weapons?)
    private static NonPlayerCharacter setUpEnemy() {
        throw new UnsupportedOperationException();
    }

    //a and b battle until one is dead
    private static void battle(Character a, Character b) {
        Character attacker = a;
        Character defender = b;

        a.makeChoice();



        while( a.isAlive() && b.isAlive() ){
            if( a.makeChoice() == 1) {
                attacker.attack(defender);
            } else {
                //TODO: consider other actions
                throw new UnsupportedOperationException();
            }

            Character temp = a;
            a = b;
            b = temp;

            //TODO: display HP status?
        }
    }

    //display some message
    private static void gameOverScreen() {
    }

//    public static PlayerCharacter setUpCharacter(){
//        Scanner scan = new Scanner(System.in);
//        System.out.println("enter you name");
//        PlayerCharacter pc = new PlayerCharacter(scan.nextLine());
//        pc.pickWeapon();
//        pc.pickArmor();
//        return pc;
//    }
}
