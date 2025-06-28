package com.example.bank_notification_system.exception;

import com.example.bank_notification_system.model.entity.User;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message, Throwable reason) {
        super(message, reason);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
