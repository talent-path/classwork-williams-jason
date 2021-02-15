package com.FirearmMuseum.FirearmMuseum.controllers;

import com.FirearmMuseum.FirearmMuseum.FirearmMuseumApplication;
import com.FirearmMuseum.FirearmMuseum.exceptions.*;
import com.FirearmMuseum.FirearmMuseum.models.Firearm;
import com.FirearmMuseum.FirearmMuseum.services.FirearmMuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
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
    public ResponseEntity addFirearm(@RequestBody Firearm toAdd)  {
        try {
            Firearm completed = service.addFirearm(toAdd);
        } catch( InvalidFirearmException | InvalidFirearmAttributeException | InvalidManufactureIdException |
                InvalidCaliberIdException | InvalidFirearmTypeIdException | InvalidActionTypeIdException|
                DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.ok(toAdd);
    }

    @DeleteMapping("/firearm/remove/{id}")
    public String removeFirearm(@PathVariable Integer id) {
        try {
            service.removeFirearmById(id);
        } catch( InvalidFirearmIdException e){
            return e.getMessage();
        }

        return "The firearm with id "+id+" was removed.";
    }

    @PostMapping("/firearm/edit/{id}")
    public String editFirearm(@PathVariable Integer id,@RequestBody Firearm toEdit){

        try {
            service.editFirearm(id,toEdit);
        } catch( InvalidFirearmIdException e){
            return e.getMessage();
        }

        return "The firearm with id "+id+" was edited.";

    }

    @GetMapping("/firearms/filtered")
    public List<Firearm> getFilteredFirearms(@RequestBody Firearm toSearch){
        return service.getFilteredFirearms(toSearch);
    }

    @GetMapping("/firearm/{id}")
    public ResponseEntity getFirearmById(@PathVariable Integer id){
        Firearm retrieved;
        try {
            retrieved = service.getFirearmById(id);
        } catch (InvalidFirearmIdException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(retrieved);
    }

    @GetMapping("/firearms/from/{startYear}/to/{endYear}")
    public List<Firearm> getFirearmsByYearRange(@PathVariable Integer startYear,@PathVariable Integer endYear){
        return service.getFirearmsByYearRange(startYear,endYear);
    }


//    @GetMapping("/firearms/dates/{date1}/{date2}")
//    public List<Firearm> getFirearmsBetweenDates(Integer date1, Integer date2){
//        return service.getFirearmsBetweenDates(date1, date2);
//    }

}
