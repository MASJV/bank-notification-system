package com.example.bank_notification_system.controller;


import com.example.bank_notification_system.exception.InsufficienctBalanceException;
import com.example.bank_notification_system.exception.UserNotFoundException;
import com.example.bank_notification_system.model.dto.CreateUserRequestDto;
import com.example.bank_notification_system.model.dto.MoneyTransferRequestDto;
import com.example.bank_notification_system.model.entity.User;
import com.example.bank_notification_system.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // ab ye controller bana
@RequestMapping("/api/v1/users")
@Slf4j // helps in logging
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<String> getbankBalance(@PathVariable("userId") int userId) throws UserNotFoundException{
        log.info("received a request to get bank balance of user with id {} ", userId);
        final User user = userService.getAUser(userId);
        String response = String.format("Mr %s. Your current balance is %s. Sent via %s",
                user.getName(), user.getBankBalance(), user.getChannel() // Will call enum's toString()
        ); // why not {} here and only %s was considered
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<User> createAUser(@RequestBody CreateUserRequestDto createUserRequestDto){
        log.info("received a request to create a user with body {} ", createUserRequestDto);
        try {
            User user = userService.createAUser(createUserRequestDto);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(404).build();
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }

    @PatchMapping
    public ResponseEntity<List<User>> moneyTransfer(@RequestBody MoneyTransferRequestDto moneyTransferRequestDto) {
        log.info("received a request to transfer {} money from user with id {} to user with id {}",
                moneyTransferRequestDto.getMoney(), moneyTransferRequestDto.getUserId1(), moneyTransferRequestDto.getUserId2());
        try {
            List<User> accountPair = userService.moneyTransfer(moneyTransferRequestDto);
            return ResponseEntity.ok(accountPair);
//        } catch (Exception ex) { // only this right as usernotfound and insufficientbalance covered in service
//            return ResponseEntity.status(500).build();
        }  catch (UserNotFoundException ex) {
            return ResponseEntity.status(400).build();
        } catch (InsufficienctBalanceException ex) {
            return ResponseEntity.status(400).build();
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }
}
