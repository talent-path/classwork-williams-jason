package com.FirearmMuseum.FirearmMuseum.persistence.mappers;

import com.FirearmMuseum.FirearmMuseum.models.Firearm;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FirearmMapper implements RowMapper<Firearm> {

    @Override
    public Firearm mapRow(ResultSet resultSet, int i) throws SQLException {
        Firearm mappedFirearm = new Firearm();
        mappedFirearm.setFirearmId(resultSet.getInt("firearmid"));
        mappedFirearm.setSerialNumber(resultSet.getInt("serialnumber"));
        mappedFirearm.setDescription(resultSet.getString("description"));
        mappedFirearm.setDonatedBy(resultSet.getString("donatedby"));
        mappedFirearm.setActionTypeId(resultSet.getInt("actiontypeid"));
        mappedFirearm.setFirearmTypeId(resultSet.getInt("firearmtypeid"));
        mappedFirearm.setManufacturerId(resultSet.getInt("manufacturerid"));
        mappedFirearm.setName(resultSet.getString("firearmname"));
        mappedFirearm.setProductionDate(resultSet.getInt("productionyear"));
        mappedFirearm.setCaliberId(resultSet.getInt("caliberid"));

        return mappedFirearm;

    }
}
