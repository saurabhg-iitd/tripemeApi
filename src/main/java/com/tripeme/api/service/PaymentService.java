package com.tripeme.api.service;

import com.tripeme.api.bo.Payment;

public interface PaymentService {
	Payment getPaymentById(String paymentId);
	Payment newPayment(Payment payment);
}
