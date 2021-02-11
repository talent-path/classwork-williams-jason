package com.FirearmMuseum.FirearmMuseum.daos;

import com.FirearmMuseum.FirearmMuseum.models.Firearm;
import com.FirearmMuseum.FirearmMuseum.persistence.PostgresFirearmDao;
import org.junit.jupiter.api.BeforeEach;
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
public class FirearmPostgresDaoTests {

    @Autowired
    PostgresFirearmDao toTest;

    @Autowired
    JdbcTemplate template;

    @BeforeEach
    public void setup(){
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
    public void addFirearmGoldenPathTest(){

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
    public void addFirearmInvalidActionType() throws DataIntegrityViolationException{

        try{
            Firearm partialToAdd = new Firearm();
            partialToAdd.setSerialNumber(123);
            partialToAdd.setDescription("test description");
            partialToAdd.setDonatedBy("test donatedby");
            partialToAdd.setActionTypeId(2);
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
    public void addFirearmInvalidFirearmType() throws DataIntegrityViolationException{

        try{
            Firearm partialToAdd = new Firearm();
            partialToAdd.setSerialNumber(123);
            partialToAdd.setDescription("test description");
            partialToAdd.setDonatedBy("test donatedby");
            partialToAdd.setActionTypeId(1);
            partialToAdd.setFirearmTypeId(2);
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
    public void addFirearmInvalidManufacturer() throws DataIntegrityViolationException{

        try{
            Firearm partialToAdd = new Firearm();
            partialToAdd.setSerialNumber(123);
            partialToAdd.setDescription("test description");
            partialToAdd.setDonatedBy("test donatedby");
            partialToAdd.setActionTypeId(1);
            partialToAdd.setFirearmTypeId(1);
            partialToAdd.setManufacturerId(2);
            partialToAdd.setName("test name");
            partialToAdd.setProductionDate(2021);
            partialToAdd.setCaliberId(1);

            Firearm completed = toTest.addFirearm(partialToAdd);
            fail();
        } catch (DataIntegrityViolationException e){

        }
    }

    @Test
    public void addFirearmInvalidCaliber() throws DataIntegrityViolationException{

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
            partialToAdd.setCaliberId(2);

            Firearm completed = toTest.addFirearm(partialToAdd);
            fail();
        } catch (DataIntegrityViolationException e){

        }
    }

    @Test
    public void addFirearmNullFirearm()throws NullPointerException {
        try{

            Firearm completed = toTest.addFirearm(null);
            fail();
        } catch (NullPointerException e){

        }
    }

    @Test
    public void addFirearmNullSerialNumber() throws NullPointerException{

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
            partialToAdd.setCaliberId(2);

            Firearm completed = toTest.addFirearm(partialToAdd);
        } catch (NullPointerException e){
            fail();
        }
    }

    public void addFirearmNullDescription() throws NullPointerException{

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
            partialToAdd.setCaliberId(2);

            Firearm completed = toTest.addFirearm(partialToAdd);

        } catch (NullPointerException e){
            fail();
        }
    }

    public void addFirearmNullDonatedBy() throws NullPointerException{

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
            partialToAdd.setCaliberId(2);

            Firearm completed = toTest.addFirearm(partialToAdd);

        } catch (NullPointerException e){
            fail();
        }
    }

    public void addFirearmNullActionTypeId() throws NullPointerException{

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
            partialToAdd.setCaliberId(2);

            Firearm completed = toTest.addFirearm(partialToAdd);
            fail();
        } catch (NullPointerException e){

        }
    }

    public void addFirearmNullFirearmTypeId() throws NullPointerException{

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
            partialToAdd.setCaliberId(2);

            Firearm completed = toTest.addFirearm(partialToAdd);
            fail();
        } catch (NullPointerException e){

        }
    }

    public void addFirearmNullManufacturerId() throws NullPointerException{

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
        } catch (NullPointerException e){

        }
    }

    public void addFirearmNullFirearmName() throws NullPointerException{

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
        } catch (NullPointerException e){

        }
    }

    public void addFirearmNullProductionDate() throws NullPointerException{

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
        } catch (NullPointerException e){

        }
    }

    public void addFirearmNullCaliberId() throws NullPointerException{

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
        } catch (NullPointerException e){

        }
    }
}
