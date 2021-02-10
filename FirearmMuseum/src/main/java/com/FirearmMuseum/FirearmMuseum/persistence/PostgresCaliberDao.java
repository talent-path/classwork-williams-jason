//package com.FirearmMuseum.FirearmMuseum.persistence;
//
//import com.FirearmMuseum.FirearmMuseum.models.Caliber;
//import com.FirearmMuseum.FirearmMuseum.models.Firearm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//@Component
//public class PostgresCaliberDao implements CaliberDao{
//    @Autowired
//    private JdbcTemplate template;
//
//    @Override
//    public Caliber getById(Integer caliberId) {
//        Caliber toGet = template.queryForObject("SELECT \"caliberid\", \"calibersize\" , \"caliberunit\" FROM \"Caliber\"",
//                new CaliberMapper());
//
//        getFirearmByCaliberId(toGet);
//
//        return toGet;
//    }
//
//    public List<Firearm> getFirearmByCaliberId(Caliber parentCaliber){
//
//        List<Firearm> allFirearms = template.query("SELECT * FROM \"Firearm\" WHERE \"Firearm\".\"caliberid\" = ?",
//                new PartialFirearmMapper(),
//                parentCaliber.getCaliberId());
//
//        parentCaliber.setAllFirearms( allFirearms );
//
//        return allFirearms;
//    }
//
//    class PartialFirearmMapper implements RowMapper<Firearm>{
//
//        @Override
//        public Firearm mapRow(ResultSet resultSet, int i) throws SQLException {
//            Firearm toReturn = new Firearm();
//            toReturn.setDescription( resultSet.getString("description"));
//            toReturn.setDonatedBy( resultSet.getString("donatedby"));
//            toReturn.setLinkedActionType( resultSet.getString("actiontypeid"));
//            toReturn.setLinkedFirearmType( resultSet.getString("firearmtypeid"));
//            toReturn.setName( resultSet.getString("firearmname"));
//            toReturn.setLinkedManufacturer(resultSet.getString("firearmmanufacturerid"));
//            toReturn.setProductionDate(resultSet.getInt("prodocutionyear"));
//            toReturn.setFirearmId( resultSet.getInt("firearmid"));
//
//            return toReturn;
//        }
//    }
//
//    class CaliberMapper implements RowMapper<Caliber>{
//
//
//        @Override
//        public Caliber mapRow(ResultSet resultSet, int i) throws SQLException {
//            Caliber toReturn = new Caliber();
//
//            toReturn.setCaliberSize( resultSet.getDouble("calibersize"));
//            toReturn.setCaliberUnit( resultSet.getString("caliberunit"));
//            return toReturn;
//        }
//    }
//}
