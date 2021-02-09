package com.FirearmMuseum.FirearmMuseum.persistence;

import com.FirearmMuseum.FirearmMuseum.models.Caliber;
import com.FirearmMuseum.FirearmMuseum.models.Firearm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class PostgresCaliberDao {
    @Autowired
    JdbcTemplate template;

    @Override
    public Caliber getById(Integer caliberId) {
        Caliber toGet = template.queryForObject("SELECT \"caliberid\", \"calibersize\" , \"caliberunit\" FROM \"Caliber\"",
                new CaliberMapper());

        return toGet;
    }

    public List<Firearm> getFirearmByCaliberId(Caliber parentCaliber){

        List<Firearm> allFirearms = template.query("SELECT * FROM \"Firearm\" WHERE \"Firearm\".\"caliberid\" = ?",
                new CaliberMapper(),
                parentCaliber.getCaliberSize())
    }

    class CaliberMapper implements RowMapper<Caliber>{


        @Override
        public Caliber mapRow(ResultSet resultSet, int i) throws SQLException {
            Caliber toReturn = new Caliber();

            toReturn.setCaliberSize( resultSet.getDouble("calibersize"));
            toReturn.setCaliberUnit( resultSet.getString("caliberunit"));
            return toReturn;
        }
    }
}
