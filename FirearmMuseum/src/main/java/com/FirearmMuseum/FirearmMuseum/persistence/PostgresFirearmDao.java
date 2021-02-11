package com.FirearmMuseum.FirearmMuseum.persistence;

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
    public Firearm addFirearm(Firearm toAdd){

        //Integer firearmId = template.queryForObject("INSERT INTO \"Firearm\" \"serialnumber\",\"description\",+\"donatedby\",\"actiontypeid\",\"firearmtypeid\",\"manufacturerid\",\"firearmname\",\"productionyear\" VALUES (?,?,?,?,?,?,?,?) RETURNING \"firearmid\";",
        //        new FirearmMapper(),toAdd.getSerialNumber(),toAdd.getDescription(),toAdd.getDonatedBy(), toAdd.getLinkedActionType(),toAdd.getLinkedFirearmType(),toAdd.getLinkedManufacturer(),toAdd.getName(),toAdd.getProductionDate());

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

        return toAdd;

    }
}
