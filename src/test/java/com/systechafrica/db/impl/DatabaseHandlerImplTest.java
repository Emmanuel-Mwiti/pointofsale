package com.systechafrica.db.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.systechafrica.db.DatabaseHandler;
import com.systechafrica.util.Config;

public class DatabaseHandlerImplTest {
    DatabaseHandler databaseHandler;

    @BeforeEach
    void setup() {
        databaseHandler = new DatabaseHandlerImpl();
    }

    @AfterEach
    void releaseResources() {
        databaseHandler = null;
    }

    @Test
    @DisplayName("connect() - when correct credentials then a connection object should be returned")
    void connect_success() throws ClassNotFoundException, SQLException {
        Connection connection = databaseHandler.connect(Config.CONNECTION_URL, Config.DB_USER, Config.DB_PASSWORD);
        assertNotNull(connection);
    }

    @Test
    @DisplayName("connect() - when SQLException is thrown, wrong password is passed")
    void connect_Sql_Exception() throws ClassNotFoundException, SQLException {
        assertThrows(SQLException.class,
                () -> databaseHandler.connect(Config.CONNECTION_URL, Config.DB_USER, "Wrong password"),
                "Wrong password");
    }

    @Test
    @DisplayName("connect() - when no JDBC driver is found then we throw ClassNotFoundException")
    @Disabled
    void connect_Class_NotFound_Exception() {
        assertThrows(ClassNotFoundException.class,
                () -> databaseHandler.connect(Config.CONNECTION_URL, Config.DB_USER, Config.DB_PASSWORD));
    }
}
