package com.FirearmMuseum.FirearmMuseum.persistence.mappers;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FirearmIdMapper implements RowMapper<Integer> {


    @Override
    public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getInt("firearmid");
    }
}
