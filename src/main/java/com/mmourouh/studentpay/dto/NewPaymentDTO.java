package com.mmourouh.studentpay.dto;

import com.mmourouh.studentpay.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class NewPaymentDTO {
    private LocalDate date;
    private double amount;
    private PaymentType type;
    private String studentCode;
}
