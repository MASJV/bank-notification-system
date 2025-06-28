package com.example.bank_notification_system.exception;

public class InsufficienctBalanceException extends Exception{
    public InsufficienctBalanceException(String message, Throwable reason) {
        super(message, reason);
    }

    public InsufficienctBalanceException(String message) {
        super(message);
    }
}
