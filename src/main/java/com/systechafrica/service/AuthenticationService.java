package com.systechafrica.service;

import java.sql.SQLException;

public interface AuthenticationService {
    boolean authenticateUser(String username, String password) throws ClassNotFoundException, SQLException;
}
