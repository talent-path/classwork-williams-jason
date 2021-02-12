package com.FirearmMuseum.FirearmMuseum.daos;

import com.FirearmMuseum.FirearmMuseum.models.Firearm;
import com.FirearmMuseum.FirearmMuseum.persistence.FirearmDao;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("serviceTest")
public class FirearminMemDao implements FirearmDao {
    @Override
    public List<Firearm> getAllFirearms() {
        return null;
    }

    @Override
    public Firearm addFirearm(Firearm toAdd) {
        return null;
    }

    @Override
    public void removeFirearmById(Integer id) {

    }

    @Override
    public void editFirearm(Integer id, Firearm toEdit) {

    }

    @Override
    public List<Firearm> getFilteredFirearms(Firearm toSearch) {
        return null;
    }

    @Override
    public Firearm getFirearmById(Integer id) {
        return null;
    }
}
