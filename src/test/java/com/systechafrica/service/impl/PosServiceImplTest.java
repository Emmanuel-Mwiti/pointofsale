package com.systechafrica.service.impl;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.systechafrica.db.DatabaseHandler;
import com.systechafrica.db.impl.DatabaseHandlerImpl;
import com.systechafrica.service.AuthenticationService;
import com.systechafrica.service.PaymentService;
import com.systechafrica.service.PosService;

public class PosServiceImplTest {
    private PosService posService;

    @BeforeEach
    void setup() {
        DatabaseHandler databaseHandler = new DatabaseHandlerImpl();
        Logger logger = Logger.getLogger(PosServiceImplTest.class.getName());
        AuthenticationService authenticationService = new AuthenticationServiceImpl(databaseHandler, logger);
        PaymentService paymentService = new PaymentServiceImpl(databaseHandler, logger);
        posService = new PosServiceImpl(authenticationService, paymentService, logger);
    }

    @Test
    @Disabled
    void testStartApplication() {
        posService.startApplication();

    }
}
