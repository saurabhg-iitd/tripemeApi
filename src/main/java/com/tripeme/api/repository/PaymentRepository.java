package com.tripeme.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tripeme.api.bo.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
}
