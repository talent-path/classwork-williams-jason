package com.FirearmMuseum.FirearmMuseum.services;

import com.FirearmMuseum.FirearmMuseum.models.Firearm;
//import com.FirearmMuseum.FirearmMuseum.persistence.CaliberDao;
import com.FirearmMuseum.FirearmMuseum.persistence.FirearmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FirearmMuseumService {

    @Autowired
    FirearmDao firearmDao;

//    @Autowired
//    CaliberDao caliberDao;

    public List<Firearm> getAllFirearms(){
        return firearmDao.getAllFirearms();
    };

    public Firearm addFirearm(Firearm toAdd){
        return firearmDao.addFirearm(toAdd);
    }
}
