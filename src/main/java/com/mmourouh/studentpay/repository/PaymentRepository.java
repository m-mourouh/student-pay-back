package com.mmourouh.studentpay.repository;

import com.mmourouh.studentpay.entities.Payment;
import com.mmourouh.studentpay.enums.PaymentStatus;
import com.mmourouh.studentpay.enums.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStudentCode(String code);

    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymentType type);

}
