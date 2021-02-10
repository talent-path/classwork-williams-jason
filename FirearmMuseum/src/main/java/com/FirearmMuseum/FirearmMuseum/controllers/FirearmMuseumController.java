package com.FirearmMuseum.FirearmMuseum.controllers;

import com.FirearmMuseum.FirearmMuseum.FirearmMuseumApplication;
import com.FirearmMuseum.FirearmMuseum.models.Firearm;
import com.FirearmMuseum.FirearmMuseum.services.FirearmMuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FirearmMuseumController {

    @Autowired
    FirearmMuseumService service;

    @GetMapping("/firearms")
    public List<Firearm> getAllFirearms(){
        return service.getAllFirearms();
    }

    @PostMapping("/firearm")
    public ResponseEntity addFirearm(@RequestBody Firearm toAdd){

        Firearm completed = service.addFirearm( toAdd );

        return ResponseEntity.ok(completed);
    }

}
