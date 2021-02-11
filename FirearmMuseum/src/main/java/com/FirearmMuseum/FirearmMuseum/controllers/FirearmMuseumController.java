package com.FirearmMuseum.FirearmMuseum.controllers;

import com.FirearmMuseum.FirearmMuseum.FirearmMuseumApplication;
import com.FirearmMuseum.FirearmMuseum.exceptions.*;
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

    //TODO: Replace throws exceptions with try catch blocks around methods

    @GetMapping("/firearms")
    public List<Firearm> getAllFirearms(){
        return service.getAllFirearms();
    }

    @PostMapping("/firearm")
    public ResponseEntity addFirearm(@RequestBody Firearm toAdd) throws InvalidActionTypeIdException, InvalidFirearmAttributeException, InvalidManufactureIdException, InvalidCaliberIdException, InvalidFirearmTypeIdException, InvalidFirearmException  {

        Firearm completed = service.addFirearm( toAdd );

        return ResponseEntity.ok(completed);
    }

    @DeleteMapping("/firearm/remove/{id}")
    public void removeFirearm(@PathVariable Integer id) throws InvalidActionTypeIdException {
        service.removeFirearmById(id);
    }

    @PostMapping("/firearm/edit/{id}")
    public void editFirearm(@PathVariable Integer id,@RequestBody Firearm toEdit){
        service.editFirearm(id,toEdit);

    }

    @GetMapping("/firearms/filtered")
    public List<Firearm> getFilteredFirearms(@RequestBody Firearm toSearch){
        return service.getFilteredFirearms(toSearch);
    }

}
