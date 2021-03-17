package com.alfadigital.testapp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManagerJdbcImpl implements ConnectionManager {

    public static final ConnectionManager INSTANCE = new ConnectionManagerJdbcImpl();

    //    Обработку и логгирование ошибок не делал т.к этого нет в задании

    private ConnectionManagerJdbcImpl() {
    }

    public static ConnectionManager getInstance() {
        return INSTANCE;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/test_db",
                    "postgres",
                    "4444");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
