package com.FirearmMuseum.FirearmMuseum.controllers;

import com.FirearmMuseum.FirearmMuseum.FirearmMuseumApplication;
import com.FirearmMuseum.FirearmMuseum.models.Firearm;
import com.FirearmMuseum.FirearmMuseum.services.FirearmMuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class FirearmMuseumController {

    @Autowired
    FirearmMuseumService service;

    @GetMapping
    public List<Firearm> getAllFirearms(){
        return service.getAllFirearms;
    }

    @PostMapping
    public ResponseEntity addFirearm(@RequestBody Firearm toAdd){
        return service.addFirearm( toAdd );
    }
}
