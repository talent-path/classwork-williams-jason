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
public class FirearmPostgresDaoGoldenPathTests {

    @Autowired
    PostgresFirearmDao toTest;

    @Autowired
    JdbcTemplate template;

    @BeforeEach
    public void setup(){
        template.update("\tTRUNCATE \"ActionType\",\"Caliber\",\"FirearmType\",\"Manufacturer\",\"Firearm\" RESTART IDENTITY;");

        template.update("INSERT INTO \"ActionType\" (\"actiontypename\")\n" +
                "VALUES ('action type test 1'),('action type test 2');");

        template.update("INSERT INTO \"Caliber\" (\"calibersize\",\"caliberunit\")\n" +
                "VALUES ('1','caliber unit test 1'),('2','caliber unit test 2');");

        template.update("INSERT INTO \"FirearmType\" (\"firearmtypename\")\n" +
                "VALUES ('firearm type test 1'),('firearm type test 2');");

        template.update("INSERT INTO \"Manufacturer\" (\"manufacturername\")\n" +
                "VALUES ('manufacturer name test 1'),('manufacturer name test 2');");
    }

    @Test
    public void addFirearmGoldenPathTest()
            throws InvalidFirearmTypeIdException, InvalidActionTypeIdException, InvalidCaliberIdException,
            InvalidManufactureIdException, InvalidFirearmAttributeException, InvalidFirearmException  {

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

        assertEquals(1,completed.getFirearmId());
        assertEquals(123,completed.getSerialNumber());
        assertEquals("test description",completed.getDescription());
        assertEquals("test donatedby",completed.getDonatedBy());
        assertEquals(1,completed.getActionTypeId());
        assertEquals(1,completed.getFirearmTypeId());
        assertEquals(1,completed.getManufacturerId());
        assertEquals("test name",completed.getName());
        assertEquals(2021,completed.getProductionDate());
        assertEquals(1,completed.getCaliberId());

        List<Firearm> allFirearms = toTest.getAllFirearms();

        assertEquals(1,allFirearms.get(0).getFirearmId());
        assertEquals(123,allFirearms.get(0).getSerialNumber());
        assertEquals("test description",allFirearms.get(0).getDescription());
        assertEquals("test donatedby",allFirearms.get(0).getDonatedBy());
        assertEquals(1,allFirearms.get(0).getActionTypeId());
        assertEquals(1,allFirearms.get(0).getFirearmTypeId());
        assertEquals(1,allFirearms.get(0).getManufacturerId());
        assertEquals("test name",allFirearms.get(0).getName());
        assertEquals(2021,allFirearms.get(0).getProductionDate());
        assertEquals(1,allFirearms.get(0).getCaliberId());
    }

    @Test
    public void deleteFirearmByIdGoldenPathTest()
            throws InvalidFirearmAttributeException, InvalidFirearmException, InvalidActionTypeIdException,
            InvalidFirearmTypeIdException, InvalidManufactureIdException, InvalidCaliberIdException, InvalidFirearmIdException {

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

        toTest.removeFirearmById(partialToAdd.getFirearmId());

        assertEquals(0,toTest.getAllFirearms().size());
    }

    @Test
    public void editFirearmGoldenPathTest()
            throws InvalidFirearmAttributeException, InvalidFirearmException, InvalidActionTypeIdException,
            InvalidFirearmTypeIdException, InvalidManufactureIdException, InvalidCaliberIdException, InvalidFirearmIdException {

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

        Firearm newInfo = new Firearm();
        newInfo.setSerialNumber(1234);
        newInfo.setDescription("test description 1234");
        newInfo.setDonatedBy("test donatedby 1234");
        newInfo.setActionTypeId(2);
        newInfo.setFirearmTypeId(2);
        newInfo.setManufacturerId(2);
        newInfo.setName("test name 1234");
        newInfo.setProductionDate(2020);
        newInfo.setCaliberId(2);

        toTest.editFirearm(completed.getFirearmId(), newInfo);

        completed = toTest.getFirearmById(completed.getFirearmId());



        assertEquals(1234,completed.getSerialNumber());
        assertEquals("test description 1234",completed.getDescription());
        assertEquals("test donatedby 1234",completed.getDonatedBy());
        assertEquals(2,completed.getActionTypeId());
        assertEquals(2,completed.getFirearmTypeId());
        assertEquals(2,completed.getManufacturerId());
        assertEquals("test name 1234",completed.getName());
        assertEquals(2020,completed.getProductionDate());
        assertEquals(2,completed.getCaliberId());

//        toTest.editFirearm();
    }
}
