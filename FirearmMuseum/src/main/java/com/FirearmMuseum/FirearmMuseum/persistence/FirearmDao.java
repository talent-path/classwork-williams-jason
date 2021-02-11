package com.FirearmMuseum.FirearmMuseum.persistence;

import com.FirearmMuseum.FirearmMuseum.exceptions.*;
import com.FirearmMuseum.FirearmMuseum.models.Firearm;

import java.util.List;

public interface FirearmDao {
    List<Firearm> getAllFirearms();

    Firearm addFirearm(Firearm toAdd) throws InvalidCaliberIdException, InvalidFirearmAttributeException, InvalidManufactureIdException, InvalidFirearmTypeIdException, InvalidActionTypeIdException, InvalidFirearmException;

    void removeFirearmById(Integer id) throws InvalidActionTypeIdException;

    void editFirearm(Integer id, Firearm toEdit);

    List<Firearm> getFilteredFirearms(Firearm toSearch);
}
