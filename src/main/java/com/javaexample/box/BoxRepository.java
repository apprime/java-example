package com.javaexample.box;

import com.javaexample.data.DatabaseAccess;
import com.javaexample.infrastructure.Repository;
import com.javaexample.colours.Colour;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BoxRepository implements Repository<Box> {

    @Autowired
    DatabaseAccess databaseAccess;

    @PostConstruct
    public void Init(){
        databaseAccess.Db().Update("CREATE TABLE IF NOT EXISTS boxes (" +
                "name VARCHAR(512) NOT NULL, " +
                "cost DECIMAL NOT NULL," +
                "country VARCHAR(128) NOT NULL," +
                "colour VARCHAR(6) NOT NULL," +
                "weight BIGINT NOT NULL" +
                ");");
    }

    @Override
    public Box Create(Box item) {
        boolean result =
            databaseAccess.Db().Update(
    "INSERT INTO boxes(name, cost, weight, country, colour)" +
            "VALUES (?, ?, ?, ?, ?)",
            preparedStatement -> {
                try {
                    preparedStatement.setString(1, item.getName());
                    preparedStatement.setBigDecimal(2, item.getCost());
                    preparedStatement.setLong(3, item.getWeight());
                    preparedStatement.setString(4, item.getCountry());
                    preparedStatement.setString(5, item.getColour().toHex());
                } catch (SQLException ex) {
                    //Fail silently
                }
            });

        return result ? item  : null;
    }

    @Override
    public Collection<Box> Read() {
        List<Box> boxes = new ArrayList();

        databaseAccess.Db()
            .Query(
                "SELECT name, cost, weight, country, colour" +
                        " FROM boxes",
                resultSet -> {
                    Box newBox = new Box();
                    try{
                        newBox.setName(resultSet.getString("name"));
                        newBox.setCost(resultSet.getBigDecimal("cost"));
                        newBox.setWeight(resultSet.getLong("weight"));
                        newBox.setCountry(resultSet.getString("country"));
                        newBox.setColour(Colour.parse(resultSet.getString("colour")));
                    } catch (SQLException ex){
                        //Fail silently.
                    }

                    boxes.add(newBox);
                });


        return boxes;
    }
}
