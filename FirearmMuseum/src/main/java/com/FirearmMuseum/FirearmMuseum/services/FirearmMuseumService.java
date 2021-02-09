package com.FirearmMuseum.FirearmMuseum.services;

import com.FirearmMuseum.FirearmMuseum.models.Firearm;
import com.FirearmMuseum.FirearmMuseum.persistence.FirearmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class FirearmMuseumService {

    @Autowired
    FirearmDao dao;

    public List<Firearm> getAllFirearms(){
        return dao.getAllFirearms();
    };

    public ResponseEntity addFirearm(Firearm toAdd) {
    }
}
