package com.FirearmMuseum.FirearmMuseum.persistence;

import com.FirearmMuseum.FirearmMuseum.models.Firearm;

import java.util.List;

public interface FirearmDao {
    List<Firearm> getAllFirearms();

    Firearm addFirearm(Firearm toAdd);
}
