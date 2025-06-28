package com.example.bank_notification_system.model.dto;

import com.example.bank_notification_system.model.entity.Channel;
import com.example.bank_notification_system.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateUserRequestDto {
    private String name;
    private Channel channel;
    private Integer bankBalance;
}

// ye request body hai, JASON
/**
 * {
 *     "name": "Jaiveer",
 *     "channel": "EMAIL",
 *     "bankBalance": 100
 * }
 */
