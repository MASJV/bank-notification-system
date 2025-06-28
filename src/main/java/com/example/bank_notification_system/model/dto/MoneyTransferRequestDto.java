package com.example.bank_notification_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder // usage in this? what to build
@AllArgsConstructor
public class MoneyTransferRequestDto {
    private Integer userId1;
    private Integer userId2;
    private Integer money; // should be double. and also double or Double should be double and Integer int or Integer in ids

}

/**
 * {
 *     "userId1": 1,
 *     "userId2": 2,
 *     "money": 100
 * }
 */
