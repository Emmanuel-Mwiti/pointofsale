package com.systechafrica.service.impl;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.systechafrica.db.DatabaseHandler;
import com.systechafrica.db.impl.DatabaseHandlerImpl;
import com.systechafrica.service.AuthenticationService;

public class AuthenticationServiceImplTest {
    DatabaseHandler databaseHandler;

    private AuthenticationService authenticationService;

    @BeforeEach
    void setup() {
        databaseHandler = new DatabaseHandlerImpl();
        Logger logger = Logger.getLogger(AuthenticationServiceImplTest.class.getName());
        authenticationService = new AuthenticationServiceImpl(databaseHandler, logger);
    }

    @Test
    @DisplayName("AuthenticationService - authenticate")
    void testAuthenticateUser() {
        Executable executableSuccess = () -> assertTrue(
                (authenticationService.authenticateUser("emmanuel", "Admin123")));
        Executable executableFailure = () -> assertFalse(
                authenticationService.authenticateUser("unknown user", "unknown password"));
        assertAll(
                executableSuccess,
                executableFailure);

    }
}
