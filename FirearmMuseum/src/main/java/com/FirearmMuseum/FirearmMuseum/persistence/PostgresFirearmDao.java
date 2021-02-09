package com.FirearmMuseum.FirearmMuseum.persistence;

import com.FirearmMuseum.FirearmMuseum.models.Firearm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Component
public class PostgresFirearmDao implements FirearmDao {


    @Autowired
    JdbcTemplate template;

    @Override
    public List<Firearm> getAllFirearms() {

        List<Firearm> allFirearms = template.query("select \"Firearm\".firearmname, \"Firearm\".productionyear, \"Firearm\".description, \"FirearmType\".firearmtypename from \"Firearm\"\n" +
                "inner join \"FirearmType\"\n" +
                "on \"Firearm\".firearmtypeid = \"FirearmType\".firearmtypeid;", new FirearmMapper());

        return allFirearms;
    }

    @Override
    public Firearm addFirearm(Firearm toAdd){

        Integer firearmId = template.queryForObject("INSERT INTO \"Firearm\" \"serialnumber\",\"description\",+\"donatedby\",\"actiontypeid\",\"firearmtypeid\",\"manufacturerid\",\"firearmname\",\"productionyear\" VALUES (?,?,?,?,?,?,?,?) RETURNING \"firearmid\";",
                new FirearmMapper(),toAdd.getSerialNumber(),toAdd.getDescription(),toAdd.getDonatedBy(), toAdd.getLinkedActionType(),toAdd.getLinkedFirearmType(),toAdd.getLinkedManufacturer(),toAdd.getName(),toAdd.getProductionDate());

    }

    class FirearmMapper implements RowMapper<Firearm> {

        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("firearmid");
        }
    }
}
