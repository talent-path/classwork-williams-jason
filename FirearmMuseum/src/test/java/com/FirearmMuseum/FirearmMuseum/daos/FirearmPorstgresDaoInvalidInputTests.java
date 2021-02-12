package com.FirearmMuseum.FirearmMuseum.daos;

import com.FirearmMuseum.FirearmMuseum.exceptions.*;
import com.FirearmMuseum.FirearmMuseum.models.Firearm;
import com.FirearmMuseum.FirearmMuseum.persistence.PostgresFirearmDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("daoTesting")
public class FirearmPorstgresDaoInvalidInputTests {

    @Autowired
    PostgresFirearmDao toTest;

    @Autowired
    JdbcTemplate template;

    @Test
    public void addFirearmInvalidActionType()
            throws InvalidFirearmTypeIdException, InvalidActionTypeIdException, InvalidCaliberIdException,
            InvalidManufactureIdException, InvalidFirearmAttributeException, InvalidFirearmException  {

        try{
            Firearm partialToAdd = new Firearm();
            partialToAdd.setSerialNumber(123);
            partialToAdd.setDescription("test description");
            partialToAdd.setDonatedBy("test donatedby");
            partialToAdd.setActionTypeId(5);
            partialToAdd.setFirearmTypeId(1);
            partialToAdd.setManufacturerId(1);
            partialToAdd.setName("test name");
            partialToAdd.setProductionDate(2021);
            partialToAdd.setCaliberId(1);

            Firearm completed = toTest.addFirearm(partialToAdd);
            fail();
        } catch (DataIntegrityViolationException e){

        }
    }

    @Test
    public void addFirearmInvalidFirearmType()
            throws InvalidFirearmTypeIdException, InvalidActionTypeIdException,
            InvalidCaliberIdException, InvalidManufactureIdException, InvalidFirearmAttributeException, InvalidFirearmException  {

        try{
            Firearm partialToAdd = new Firearm();
            partialToAdd.setSerialNumber(123);
            partialToAdd.setDescription("test description");
            partialToAdd.setDonatedBy("test donatedby");
            partialToAdd.setActionTypeId(1);
            partialToAdd.setFirearmTypeId(5);
            partialToAdd.setManufacturerId(1);
            partialToAdd.setName("test name");
            partialToAdd.setProductionDate(2021);
            partialToAdd.setCaliberId(1);

            Firearm completed = toTest.addFirearm(partialToAdd);
            fail();
        } catch (DataIntegrityViolationException e){

        }
    }

    @Test
    public void addFirearmInvalidManufacturer()
            throws InvalidFirearmTypeIdException, InvalidActionTypeIdException,
            InvalidCaliberIdException, InvalidManufactureIdException, InvalidFirearmAttributeException, InvalidFirearmException {

        try{
            Firearm partialToAdd = new Firearm();
            partialToAdd.setSerialNumber(123);
            partialToAdd.setDescription("test description");
            partialToAdd.setDonatedBy("test donatedby");
            partialToAdd.setActionTypeId(1);
            partialToAdd.setFirearmTypeId(1);
            partialToAdd.setManufacturerId(5);
            partialToAdd.setName("test name");
            partialToAdd.setProductionDate(2021);
            partialToAdd.setCaliberId(1);

            Firearm completed = toTest.addFirearm(partialToAdd);
            fail();
        } catch (DataIntegrityViolationException e){

        }
    }

    @Test
    public void addFirearmInvalidCaliber()
            throws InvalidFirearmTypeIdException, InvalidActionTypeIdException,
            InvalidCaliberIdException, InvalidManufactureIdException, InvalidFirearmAttributeException, InvalidFirearmException  {

        try{
            Firearm partialToAdd = new Firearm();
            partialToAdd.setSerialNumber(123);
            partialToAdd.setDescription("test description");
            partialToAdd.setDonatedBy("test donatedby");
            partialToAdd.setActionTypeId(1);
            partialToAdd.setFirearmTypeId(1);
            partialToAdd.setManufacturerId(1);
            partialToAdd.setName("test name");
            partialToAdd.setProductionDate(2021);
            partialToAdd.setCaliberId(5);

            Firearm completed = toTest.addFirearm(partialToAdd);
            fail();
        } catch (DataIntegrityViolationException e){

        }
    }

    @Test
    public void removeFirearmByIdInvalidId() throws InvalidFirearmAttributeException, InvalidFirearmException, InvalidFirearmTypeIdException, InvalidManufactureIdException, InvalidCaliberIdException, InvalidActionTypeIdException {


        Firearm partialToAdd = new Firearm();
        partialToAdd.setSerialNumber(123);
        partialToAdd.setDescription("test description");
        partialToAdd.setDonatedBy("test donatedby");
        partialToAdd.setActionTypeId(1);
        partialToAdd.setFirearmTypeId(1);
        partialToAdd.setManufacturerId(1);
        partialToAdd.setName("test name");
        partialToAdd.setProductionDate(2021);
        partialToAdd.setCaliberId(1);
        Firearm completed = toTest.addFirearm(partialToAdd);

        try{
            toTest.removeFirearmById(1);
        } catch(InvalidFirearmIdException e){

        }


    }

    public void getFilteredFirearmInvalidInputTest(){

    }

}
