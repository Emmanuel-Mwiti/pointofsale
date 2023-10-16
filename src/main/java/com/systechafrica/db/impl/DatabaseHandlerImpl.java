package com.systechafrica.db.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.systechafrica.db.DatabaseHandler;

public class DatabaseHandlerImpl implements DatabaseHandler {

    @Override
    public Connection connection(String connectionUrl, String username, String password)
            throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(connectionUrl, username, password);
    }

}
