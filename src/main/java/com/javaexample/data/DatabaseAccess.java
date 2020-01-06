package com.javaexample.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.function.Consumer;

public interface DatabaseAccess {
    DatabaseAccess Db();
    DatabaseAccess Query(String sqlQuery, Consumer<ResultSet> consumer);
    boolean Update(String sqlQuery, Consumer<PreparedStatement> consumer);
    boolean Update(String sqlQuery);
}
