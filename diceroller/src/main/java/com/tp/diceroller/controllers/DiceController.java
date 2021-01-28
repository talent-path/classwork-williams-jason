package com.tp.diceroller.controllers;

import com.tp.diceroller.services.Rng;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiceController {

    @GetMapping("/helloWorld")
    public String hellowWorld(){
        return "Hello World!";
    }

    @GetMapping("/sixsides")
    public int sixSides(){

        return Rng.rollDice(6);
    }

    @GetMapping("/twentysides")
    public int twentySides(){
        return Rng.rollDice(20);
    }

    @GetMapping("/nsides")
    public int nSides(Integer num){
        return Rng.rollDice(num);
    }

    @GetMapping("/nsides/{num}")
    public int nSidesPathVariable(@PathVariable Integer num){
        return Rng.rollDice(num);
    }

}