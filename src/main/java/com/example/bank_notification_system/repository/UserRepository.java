package com.example.bank_notification_system.repository;

import com.example.bank_notification_system.exception.InsufficienctBalanceException;
import com.example.bank_notification_system.exception.UserNotFoundException;
import com.example.bank_notification_system.model.entity.Channel;
import com.example.bank_notification_system.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository{
    private List<User> userList;

    public UserRepository() {
        userList = new LinkedList<>();
    }

    @Override
    public User getAUser(int userId) throws UserNotFoundException {
        for(User user : userList) {
            if(user.getUserId() == userId) {
                return user;
            }
        }
        throw new UserNotFoundException("User Not Found"); // where this will be shown????
    }

    @Override
    public void createAUser(User user, Channel channel, Integer bankBalance) { // repository related to storage so storing user's data(setting)
        //user.setChannel(channel);
        userList.add(user);
    }

    @Override
    public List<User> moneyTransfer(User user1, User user2, int money) throws InsufficienctBalanceException {
        List<User> accountPair = new LinkedList<>(); // why linkedlist > arraylist??? (see recording)
        if(user1.getBankBalance() >= money && money > 0) { // added cause moneyTransfer cannot be <=0
            user1.setBankBalance(user1.getBankBalance() - money);
            user2.setBankBalance(user2.getBankBalance() + money);
            accountPair.add(user1);
            accountPair.add(user2);
            return accountPair;
        }
        throw new InsufficienctBalanceException("Insufficient Balance"); // where this is seen
    }

    @Override
    public User updateAUser(int userId, String name, Channel channel, Integer bankBalance) throws UserNotFoundException{
        final User user = getAUser(userId);
        user.setName(name);
        user.setChannel(channel);
        user.setBankBalance(bankBalance);
        return user;
    }
}
