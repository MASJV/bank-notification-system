package com.example.bank_notification_system.repository;

import com.example.bank_notification_system.exception.InsufficienctBalanceException;
import com.example.bank_notification_system.exception.UserNotFoundException;
import com.example.bank_notification_system.model.entity.Channel;
import com.example.bank_notification_system.model.entity.User;

import java.util.List;

public interface IUserRepository { // no public void, by default its public????
    void createAUser(User user, Channel channel, Integer bankBalance);
    User getAUser(int userId) throws UserNotFoundException;
    List<User> moneyTransfer(User user2, User user1, int money) throws InsufficienctBalanceException;
}
