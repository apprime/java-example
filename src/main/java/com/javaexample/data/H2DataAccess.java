package com.javaexample.data;

import java.sql.*;
import java.util.function.Consumer;

public class H2DataAccess implements DatabaseAccess {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    static final String USER = "sa";
    static final String PASS = "";

    private Connection connection = null;
    private Statement statement = null;

    public DatabaseAccess Db() {
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();
        } catch(SQLException ex) {
            //Pretend like things are ok
        } catch(ClassNotFoundException ex){
            //Pretend like things are ok
        } finally {
            return this;
        }
    }

    public boolean Update(String sqlQuery, Consumer<PreparedStatement> consumer){
        try {
            PreparedStatement prepState = connection.prepareStatement(sqlQuery);
            consumer.accept(prepState);
            int rowCount = prepState.executeUpdate();
            prepState.close();
            return rowCount > 0;
        } catch (SQLException e) {
            return false;
        } finally {
            Cleanup();
        }
    }

    public boolean Update(String sqlQuery){
        try {
            PreparedStatement prepState = connection.prepareStatement(sqlQuery);
            int rowCount = prepState.executeUpdate();
            prepState.close();
            return rowCount > 0;
        } catch (SQLException e) {
            return false;
        } finally {
            Cleanup();
        }
    }

    public DatabaseAccess Query(String sqlQuery, Consumer<ResultSet> consumer) {
        try {
            ResultSet result = statement.executeQuery(sqlQuery);
            while(result.next()){
                consumer.accept(result);
            }
        } catch (SQLException ex){
            //Pretend like things are ok
        } finally{
            Cleanup();
            return this;
        }
    }

    private void Cleanup(){
        try {
            if(statement!=null) statement.close();
        } catch (SQLException se2) {
        }
        try {
            if(connection!=null) connection.close();
        } catch(SQLException se) {
            //Pretend like things are ok
        }
    }
}
