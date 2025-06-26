package com.example.bank_notification_system.service;


import com.example.bank_notification_system.exception.InsufficienctBalanceException;
import com.example.bank_notification_system.exception.UserNotFoundException;
import com.example.bank_notification_system.model.dto.CreateUserRequestDto;
import com.example.bank_notification_system.model.dto.MoneyTransferRequestDto;
import com.example.bank_notification_system.model.entity.User;
import com.example.bank_notification_system.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor // means only required ones and all in only the one all argument constructor????
public class UserService {
    private final IUserRepository userRepository;

    public User createAUser(final CreateUserRequestDto createUserRequestDto) throws UserNotFoundException {
        final User user = new User(createUserRequestDto.getName(), createUserRequestDto.getChannel(),
                                    createUserRequestDto.getBankBalance());
        // isse new User as set nahi hoga user ka chanenel through constructor
        userRepository.createAUser(user, createUserRequestDto.getChannel(), createUserRequestDto.getBankBalance());
        return user;
    }

    public User getAUser(int userId) throws UserNotFoundException{ // not used in controller
        User user = userRepository.getAUser(userId);
        return user;
    }

    public List<User> moneyTransfer(final MoneyTransferRequestDto moneyTransferRequestDto) throws UserNotFoundException, InsufficienctBalanceException {
        User user1 = getAUser(moneyTransferRequestDto.getUserId1());
        User user2 = getAUser(moneyTransferRequestDto.getUserId2());
        return userRepository.moneyTransfer(user1, user2, moneyTransferRequestDto.getMoney());

    }
}
