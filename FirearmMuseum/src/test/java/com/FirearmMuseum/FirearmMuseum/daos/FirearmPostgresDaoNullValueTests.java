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
public class FirearmPostgresDaoNullValueTests {

    @Autowired
    PostgresFirearmDao toTest;

    @Autowired
    JdbcTemplate template;

    @BeforeEach
    public void setup() {
        template.update("\tTRUNCATE \"ActionType\",\"Caliber\",\"FirearmType\",\"Manufacturer\",\"Firearm\" RESTART IDENTITY;");

        template.update("INSERT INTO \"ActionType\" (\"actiontypename\")\n" +
                "VALUES ('action type test 1');");

        template.update("INSERT INTO \"Caliber\" (\"calibersize\",\"caliberunit\")\n" +
                "VALUES ('1','caliber unit test 1');");

        template.update("INSERT INTO \"FirearmType\" (\"firearmtypename\")\n" +
                "VALUES ('firearm type test 1');");

        template.update("INSERT INTO \"Manufacturer\" (\"manufacturername\")\n" +
                "VALUES ('manufacturer name test 1');");
    }
    @Test
    public void addFirearmNullFirearm()
            throws InvalidFirearmTypeIdException, InvalidActionTypeIdException,
            InvalidCaliberIdException, InvalidManufactureIdException, InvalidFirearmAttributeException, InvalidFirearmException  {

        try{
            Firearm toAdd = null;
            toTest.addFirearm(toAdd);
            fail();
        } catch (InvalidFirearmException e){

        }
    }

    @Test
    public void addFirearmNullSerialNumber()
            throws InvalidFirearmTypeIdException, InvalidActionTypeIdException,
            InvalidCaliberIdException, InvalidManufactureIdException, InvalidFirearmAttributeException, InvalidFirearmException  {

        try{
            Firearm partialToAdd = new Firearm();
            partialToAdd.setSerialNumber(null);
            partialToAdd.setDescription("test description");
            partialToAdd.setDonatedBy("test donatedby");
            partialToAdd.setActionTypeId(1);
            partialToAdd.setFirearmTypeId(1);
            partialToAdd.setManufacturerId(1);
            partialToAdd.setName("test name");
            partialToAdd.setProductionDate(2021);
            partialToAdd.setCaliberId(1);

            Firearm completed = toTest.addFirearm(partialToAdd);
        } catch (NullPointerException e){
            fail();
        }
    }

    @Test
    public void addFirearmNullDescription()
            throws InvalidFirearmTypeIdException, InvalidActionTypeIdException,
            InvalidCaliberIdException, InvalidManufactureIdException, InvalidFirearmAttributeException, InvalidFirearmException  {

        try{
            Firearm partialToAdd = new Firearm();
            partialToAdd.setSerialNumber(123);
            partialToAdd.setDescription(null);
            partialToAdd.setDonatedBy("test donatedby");
            partialToAdd.setActionTypeId(1);
            partialToAdd.setFirearmTypeId(1);
            partialToAdd.setManufacturerId(1);
            partialToAdd.setName("test name");
            partialToAdd.setProductionDate(2021);
            partialToAdd.setCaliberId(1);

            Firearm completed = toTest.addFirearm(partialToAdd);

        } catch (NullPointerException e){
            fail();
        }
    }

    @Test
    public void addFirearmNullDonatedBy()
            throws InvalidFirearmTypeIdException, InvalidActionTypeIdException,
            InvalidCaliberIdException, InvalidManufactureIdException, InvalidFirearmAttributeException, InvalidFirearmException  {

        try{
            Firearm partialToAdd = new Firearm();
            partialToAdd.setSerialNumber(123);
            partialToAdd.setDescription("test description");
            partialToAdd.setDonatedBy(null);
            partialToAdd.setActionTypeId(1);
            partialToAdd.setFirearmTypeId(1);
            partialToAdd.setManufacturerId(1);
            partialToAdd.setName("test name");
            partialToAdd.setProductionDate(2021);
            partialToAdd.setCaliberId(1);

            Firearm completed = toTest.addFirearm(partialToAdd);

        } catch (NullPointerException e){
            fail();
        }
    }

    @Test
    public void addFirearmNullActionTypeId()
            throws InvalidFirearmTypeIdException, InvalidActionTypeIdException,
            InvalidCaliberIdException, InvalidManufactureIdException, InvalidFirearmAttributeException, InvalidFirearmException {

        try{
            Firearm partialToAdd = new Firearm();
            partialToAdd.setSerialNumber(123);
            partialToAdd.setDescription("test description");
            partialToAdd.setDonatedBy("test donatedby");
            partialToAdd.setActionTypeId(null);
            partialToAdd.setFirearmTypeId(1);
            partialToAdd.setManufacturerId(1);
            partialToAdd.setName("test name");
            partialToAdd.setProductionDate(2021);
            partialToAdd.setCaliberId(1);

            Firearm completed = toTest.addFirearm(partialToAdd);
            fail();
        } catch (InvalidActionTypeIdException e){

        }
    }

    @Test
    public void addFirearmNullFirearmTypeId()
            throws InvalidFirearmTypeIdException, InvalidActionTypeIdException,
            InvalidCaliberIdException, InvalidManufactureIdException, InvalidFirearmAttributeException, InvalidFirearmException  {

        try{
            Firearm partialToAdd = new Firearm();
            partialToAdd.setSerialNumber(123);
            partialToAdd.setDescription("test description");
            partialToAdd.setDonatedBy("test donatedby");
            partialToAdd.setActionTypeId(1);
            partialToAdd.setFirearmTypeId(null);
            partialToAdd.setManufacturerId(1);
            partialToAdd.setName("test name");
            partialToAdd.setProductionDate(2021);
            partialToAdd.setCaliberId(1);

            Firearm completed = toTest.addFirearm(partialToAdd);
            fail();
        } catch (InvalidFirearmTypeIdException e){

        }
    }

    @Test
    public void addFirearmNullManufacturerId()
            throws InvalidFirearmTypeIdException, InvalidActionTypeIdException,
            InvalidCaliberIdException, InvalidFirearmAttributeException, InvalidFirearmException  {

        try{
            Firearm partialToAdd = new Firearm();
            partialToAdd.setSerialNumber(123);
            partialToAdd.setDescription("test description");
            partialToAdd.setDonatedBy("test donatedby");
            partialToAdd.setActionTypeId(1);
            partialToAdd.setFirearmTypeId(1);
            partialToAdd.setManufacturerId(null);
            partialToAdd.setName("test name");
            partialToAdd.setProductionDate(2021);
            partialToAdd.setCaliberId(2);

            Firearm completed = toTest.addFirearm(partialToAdd);
            fail();
        } catch (InvalidManufactureIdException e){

        }
    }

    @Test
    public void addFirearmNullFirearmName()
            throws InvalidFirearmTypeIdException, InvalidActionTypeIdException,
            InvalidCaliberIdException, InvalidManufactureIdException, InvalidFirearmException  {

        try{
            Firearm partialToAdd = new Firearm();
            partialToAdd.setSerialNumber(123);
            partialToAdd.setDescription("test description");
            partialToAdd.setDonatedBy("test donatedby");
            partialToAdd.setActionTypeId(1);
            partialToAdd.setFirearmTypeId(1);
            partialToAdd.setManufacturerId(1);
            partialToAdd.setName(null);
            partialToAdd.setProductionDate(2021);
            partialToAdd.setCaliberId(2);

            Firearm completed = toTest.addFirearm(partialToAdd);
            fail();
        } catch (InvalidFirearmAttributeException e){

        }
    }

    @Test
    public void addFirearmNullProductionDate()
            throws InvalidFirearmTypeIdException, InvalidActionTypeIdException,
            InvalidCaliberIdException, InvalidManufactureIdException, InvalidFirearmException  {

        try{
            Firearm partialToAdd = new Firearm();
            partialToAdd.setSerialNumber(123);
            partialToAdd.setDescription("test description");
            partialToAdd.setDonatedBy("test donatedby");
            partialToAdd.setActionTypeId(1);
            partialToAdd.setFirearmTypeId(1);
            partialToAdd.setManufacturerId(1);
            partialToAdd.setName("test name");
            partialToAdd.setProductionDate(null);
            partialToAdd.setCaliberId(2);

            Firearm completed = toTest.addFirearm(partialToAdd);
            fail();
        } catch (InvalidFirearmAttributeException e){

        }
    }

    @Test
    public void addFirearmNullCaliberId()
            throws InvalidFirearmTypeIdException, InvalidActionTypeIdException,
            InvalidManufactureIdException, InvalidFirearmAttributeException, InvalidFirearmException  {

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
            partialToAdd.setCaliberId(null);

            Firearm completed = toTest.addFirearm(partialToAdd);
            fail();
        } catch (InvalidCaliberIdException e){

        }
    }
}
