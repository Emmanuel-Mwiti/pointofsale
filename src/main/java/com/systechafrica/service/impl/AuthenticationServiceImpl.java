package com.systechafrica.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.systechafrica.db.DatabaseHandler;
import com.systechafrica.service.AuthenticationService;
import com.systechafrica.util.Config;

public class AuthenticationServiceImpl implements AuthenticationService {
    DatabaseHandler databaseHandler;
    Logger logger;

    public AuthenticationServiceImpl(DatabaseHandler databaseHandler, Logger logger) {
        this.databaseHandler = databaseHandler;
        this.logger = logger;

    }

    @Override
    public boolean authenticateUser(String username, String password) throws ClassNotFoundException, SQLException {
        Connection connection = databaseHandler.connect(Config.CONNECTION_URL, Config.DB_USER, Config.DB_PASSWORD);
        PreparedStatement preparedStatement = connection
                .prepareStatement(("select * from users where username=? and password=?"));
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return true;
        }
        return false;
    }

}
