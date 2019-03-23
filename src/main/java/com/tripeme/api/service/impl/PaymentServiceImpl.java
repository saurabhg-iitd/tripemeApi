package com.tripeme.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripeme.api.bo.Payment;
import com.tripeme.api.repository.PaymentRepository;
import com.tripeme.api.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public Payment getPaymentById(String paymentId) {
		return paymentRepository.getOne(paymentId);
	}

	@Override
	public Payment newPayment(Payment payment) {
		return paymentRepository.save(payment);
	}

}
