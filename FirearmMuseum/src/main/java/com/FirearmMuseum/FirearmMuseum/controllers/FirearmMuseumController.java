package com.FirearmMuseum.FirearmMuseum.controllers;

import com.FirearmMuseum.FirearmMuseum.FirearmMuseumApplication;
import com.FirearmMuseum.FirearmMuseum.exceptions.*;
import com.FirearmMuseum.FirearmMuseum.models.Firearm;
import com.FirearmMuseum.FirearmMuseum.services.FirearmMuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public String removeFirearm(@PathVariable Integer id) {
        try {
            service.removeFirearmById(id);
        } catch( InvalidFirearmIdException e){

        }

        ResponseEntity.ok();
    }

    @PostMapping("/firearm/edit/{id}")
    public void editFirearm(@PathVariable Integer id,@RequestBody Firearm toEdit){
        service.editFirearm(id,toEdit);

    }

    @GetMapping("/firearms/filtered")
    public List<Firearm> getFilteredFirearms(@RequestBody Firearm toSearch){
        return service.getFilteredFirearms(toSearch);
    }

    @GetMapping("/firearm/{id}")
    public Firearm getFirearmById(@PathVariable Integer id){
        return service.getFirearmById(id);
    }


//    @GetMapping("/firearms/dates/{date1}/{date2}")
//    public List<Firearm> getFirearmsBetweenDates(Integer date1, Integer date2){
//        return service.getFirearmsBetweenDates(date1, date2);
//    }

}
