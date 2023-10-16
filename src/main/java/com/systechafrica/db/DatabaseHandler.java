package com.systechafrica.db;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseHandler {
    Connection connection(String connectionUrl, String username, String password)
            throws ClassNotFoundException, SQLException;
}
