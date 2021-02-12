package com.FirearmMuseum.FirearmMuseum.persistence;

import com.FirearmMuseum.FirearmMuseum.exceptions.*;
import com.FirearmMuseum.FirearmMuseum.models.Firearm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.FirearmMuseum.FirearmMuseum.persistence.mappers.*;

import java.util.List;

@Component
public class PostgresFirearmDao implements FirearmDao {


    @Autowired
    private JdbcTemplate template;

    @Override
    public List<Firearm> getAllFirearms() {

        List<Firearm> allFirearms = template.query("SELECT \"Firearm\".firearmid,\"Firearm\".serialnumber,\"Firearm\".description,\"Firearm\".donatedby,\"Firearm\".actiontypeid,\"Firearm\".firearmtypeid,\"Firearm\".manufacturerid,\"Firearm\".firearmname,\"Firearm\".productionyear,\"Firearm\".caliberid\n" +
                        "FROM \"Firearm\";",
                new FirearmMapper() );

        return allFirearms;
    }

    @Override
    public Firearm addFirearm(Firearm toAdd) throws InvalidCaliberIdException, InvalidFirearmAttributeException, InvalidManufactureIdException, InvalidFirearmTypeIdException, InvalidActionTypeIdException, InvalidFirearmException {

        //Integer firearmId = template.queryForObject("INSERT INTO \"Firearm\" \"serialnumber\",\"description\",+\"donatedby\",\"actiontypeid\",\"firearmtypeid\",\"manufacturerid\",\"firearmname\",\"productionyear\" VALUES (?,?,?,?,?,?,?,?) RETURNING \"firearmid\";",
        //        new FirearmMapper(),toAdd.getSerialNumber(),toAdd.getDescription(),toAdd.getDonatedBy(), toAdd.getLinkedActionType(),toAdd.getLinkedFirearmType(),toAdd.getLinkedManufacturer(),toAdd.getName(),toAdd.getProductionDate());


        if(toAdd == null)
            throw new InvalidFirearmException("The Firearm object was null");
        if(toAdd.getActionTypeId()==null)
            throw new InvalidActionTypeIdException("The Action type entered was null");
        if(toAdd.getFirearmTypeId()==null)
            throw new InvalidFirearmTypeIdException("The Firearm type entered was null");
        if(toAdd.getManufacturerId()==null)
            throw new InvalidManufactureIdException("The Manufacturer entered was null");
        if(toAdd.getName()==null)
            throw new InvalidFirearmAttributeException("The name entered was null");
        if(toAdd.getProductionDate()==null)
            throw new InvalidFirearmAttributeException("The production year entered was null");
        if(toAdd.getCaliberId()==null)
            throw new InvalidCaliberIdException("The caliber entered was null");


        Integer firearmId = template.queryForObject("insert into \"Firearm\" (\"serialnumber\",\"description\",\"donatedby\",\"actiontypeid\",\n" +
                "\t\t\t\t\t   \"firearmtypeid\",\"manufacturerid\",\"firearmname\",\"productionyear\",\"caliberid\")\n" +
                "VALUES (?,?,?,?,?,?,?,?,?) RETURNING \"firearmid\";",
                new FirearmIdMapper(),
                toAdd.getSerialNumber(),
                toAdd.getDescription(),
                toAdd.getDonatedBy(),
                toAdd.getActionTypeId(),
                toAdd.getFirearmTypeId(),
                toAdd.getManufacturerId(),
                toAdd.getName(),
                toAdd.getProductionDate(),
                toAdd.getCaliberId());

        toAdd.setFirearmId( firearmId );
        if(toAdd.getFirearmId()==null)
            throw new InvalidFirearmAttributeException("The Firearm id was null");
        return toAdd;

    }

    @Override
    public void removeFirearmById(Integer id) throws InvalidFirearmIdException {
        boolean idExists = false;
        for (int i = 0; i < getAllFirearms().size(); i++) {
            if(getAllFirearms().get(i).getFirearmId()==id){
                idExists=true;
            }
        }
        if(idExists) {
            template.update("DELETE FROM \"Firearm\"\n" +
                    "WHERE \"Firearm\".firearmid = \'" + id + "\';");
        } else {
            throw new InvalidFirearmIdException("The firearm with that id doesnt exist or was already deleted");
        }
    }



    @Override
    public void editFirearm(Integer id, Firearm toEdit) throws InvalidFirearmIdException {

        boolean idExists = false;
        for (int i = 0; i < getAllFirearms().size(); i++) {
            if(getAllFirearms().get(i).getFirearmId()==id){
                idExists=true;
            }
        }

        if(!idExists)
            throw new InvalidFirearmIdException("The id entered is invalid");

        Integer newSerialNum = toEdit.getSerialNumber();
        String newDescription = toEdit.getDescription();
        String newDonatedBy = toEdit.getDonatedBy();
        Integer newActionTypeId = toEdit.getActionTypeId();
        Integer newFirearmTypeId = toEdit.getFirearmTypeId();
        Integer newManufacturerId = toEdit.getManufacturerId();
        String newName = toEdit.getName();
        Integer newProductionYear = toEdit.getProductionDate();
        Integer newCaliberId = toEdit.getCaliberId();
        Firearm original = getFirearmById(id);
        if(newSerialNum!=null) {
            template.update("UPDATE \"Firearm\" SET \"serialnumber\" = '" + newSerialNum + "' WHERE \"firearmid\" = '" + id + "';");
            original.setSerialNumber(newSerialNum);
        }
        if(newDescription!=null) {
            template.update("UPDATE \"Firearm\" SET \"description\" = '" + newDescription + "' WHERE \"firearmid\" = '" + id + "';");
            original.setDescription(newDescription);
        }
        if(newDonatedBy!=null) {
            template.update("UPDATE \"Firearm\" SET \"donatedby\" = '" + newDonatedBy + "' WHERE \"firearmid\" = '" + id + "';");
            original.setDonatedBy(newDonatedBy);
        }
        if(newActionTypeId!=null) {
            template.update("UPDATE \"Firearm\" SET \"actiontypeid\" = '" + newActionTypeId + "' WHERE \"firearmid\" = '" + id + "';");
            original.setActionTypeId(newActionTypeId);
        }
        if(newFirearmTypeId!=null) {
            template.update("UPDATE \"Firearm\" SET \"firearmtypeid\" = '" + newFirearmTypeId + "' WHERE \"firearmid\" = '" + id + "';");
            original.setFirearmTypeId(newFirearmTypeId);
        }
        if(newManufacturerId!=null) {
            template.update("UPDATE \"Firearm\" SET \"manufacturerid\" = '" + newManufacturerId + "' WHERE \"firearmid\" = '" + id + "';");
            original.setManufacturerId(newManufacturerId);
        }
        if(newName!=null) {
            template.update("UPDATE \"Firearm\" SET \"firearmname\" = '" + newName + "' WHERE \"firearmid\" = '" + id + "';");
            original.setName(newName);
        }
        if(newProductionYear!=null) {
            template.update("UPDATE \"Firearm\" SET \"productionyear\" = '" + newProductionYear + "' WHERE \"firearmid\" = '" + id + "';");
            original.setProductionDate(newProductionYear);
        }
        if(newCaliberId!=null) {
            template.update("UPDATE \"Firearm\" SET \"caliberid\" = '" + newCaliberId + "' WHERE \"firearmid\" = '" + id + "';");
            original.setCaliberId(newCaliberId);
        }
    }

    @Override
    public List<Firearm> getFilteredFirearms(Firearm toSearch) {
        Integer newSerialNum = toSearch.getSerialNumber();
        String newDescription = toSearch.getDescription();
        String newDonatedBy = toSearch.getDonatedBy();
        Integer newActionTypeId = toSearch.getActionTypeId();
        Integer newFirearmTypeId = toSearch.getFirearmTypeId();
        Integer newManufacturerId = toSearch.getManufacturerId();
        String newName = toSearch.getName();
        Integer newProductionYear = toSearch.getProductionDate();
        Integer newCaliberId = toSearch.getCaliberId();

        String sqlSelect = "SELECT * ";

        //cut off last comma
        sqlSelect = sqlSelect.substring(0,sqlSelect.length()-1);

        String sqlQuery =  sqlSelect;
        sqlQuery = sqlQuery.concat(" FROM \"Firearm\"  WHERE ");

        if(newSerialNum!=null)
            sqlQuery = sqlQuery.concat("\"Firearm\".serialnumber = " + newSerialNum + " AND");
        if(newDescription!=null)
            sqlQuery = sqlQuery.concat("\"Firearm\".description = \'" + newDescription + "\' AND");
        if(newDonatedBy!=null)
            sqlQuery = sqlQuery.concat("\"Firearm\".donatedby = \'" + newDonatedBy + "\' AND");
        if(newActionTypeId!=null)
            sqlQuery = sqlQuery.concat("\"Firearm\".actiontypeid = " + newActionTypeId + " AND");
        if(newFirearmTypeId!=null)
            sqlQuery = sqlQuery.concat("\"Firearm\".firearmtypeid = " + newFirearmTypeId + " AND");
        if(newManufacturerId!=null)
            sqlQuery = sqlQuery.concat("\"Firearm\".manufacturerid = " + newManufacturerId + " AND");
        if(newName!=null)
            sqlQuery = sqlQuery.concat("\"Firearm\".firearmname = \'" + newName + "\' AND");
        if(newProductionYear!=null)
            sqlQuery = sqlQuery.concat("\"Firearm\".productionyear = " + newProductionYear + " AND");
        if(newCaliberId!=null)
            sqlQuery = sqlQuery.concat("\"Firearm\".caliberid = " + newCaliberId + " AND");

        sqlQuery = sqlQuery.substring(0,sqlQuery.length()-3);


        List<Firearm> filteredFirearms = template.query(sqlQuery,new FirearmMapper());

        return filteredFirearms;
    }

    @Override
    public Firearm getFirearmById(Integer id) {
    Firearm toReturn = null;

        for (int i = 0; i < getAllFirearms().size(); i++) {
            if(id == getAllFirearms().get(i).getFirearmId()){
                toReturn = getAllFirearms().get(i);
            }
        }

        return toReturn;
    }


}
