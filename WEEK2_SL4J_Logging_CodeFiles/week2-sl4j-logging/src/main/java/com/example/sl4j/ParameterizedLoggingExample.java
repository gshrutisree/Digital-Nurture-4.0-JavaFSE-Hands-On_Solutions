package com.example.sl4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String user = "Shruti";
        int loginAttempts = 3;
        boolean isLocked = true;

        logger.info("User {} has logged in", user);
        logger.warn("User {} had {} failed login attempts", user, loginAttempts);
        logger.error("User {} account locked: {}", user, isLocked);
    }
}
