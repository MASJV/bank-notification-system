package com.example.bank_notification_system.model.dto;

import com.example.bank_notification_system.model.entity.Channel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor

public class UpdateUserRequestDto {
    private String name;
    private Channel channel;
    private Integer bankBalance;
}


/**
 * {
 *     "name": "JV",
 *     "channel": "EMAIL",
 *     "bankBalance", 1000
 *
 * }
 */
