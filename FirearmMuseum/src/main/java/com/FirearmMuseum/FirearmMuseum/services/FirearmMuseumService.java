package com.FirearmMuseum.FirearmMuseum.services;

import com.FirearmMuseum.FirearmMuseum.exceptions.*;
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

    public Firearm addFirearm(Firearm toAdd)throws InvalidFirearmTypeIdException, InvalidActionTypeIdException,
            InvalidCaliberIdException, InvalidManufactureIdException, InvalidFirearmAttributeException, InvalidFirearmException  {

        if(toAdd.getProductionDate() > 2021)
            throw new InvalidFirearmAttributeException(toAdd.getProductionDate() + " Has not happened yet.");
        if(toAdd.getProductionDate() < 1288)
            throw new InvalidFirearmAttributeException(toAdd.getProductionDate() + "  is too early for firearms.");

        return firearmDao.addFirearm(toAdd);
    }

    public void removeFirearmById(Integer id) throws InvalidFirearmIdException {
        firearmDao.removeFirearmById(id);
    }

    public void editFirearm(Integer id, Firearm toEdit) throws InvalidFirearmIdException {
        firearmDao.editFirearm(id,toEdit);
    }

    public List<Firearm> getFilteredFirearms(Firearm toSearch) {
        return firearmDao.getFilteredFirearms(toSearch);
    }

    public Firearm getFirearmById(Integer id) {
        return firearmDao.getFirearmById(id);
    }
}
