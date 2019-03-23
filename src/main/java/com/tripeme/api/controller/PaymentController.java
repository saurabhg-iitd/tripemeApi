package com.tripeme.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tripeme.api.bo.Payment;
import com.tripeme.api.service.PaymentService;

@RestController
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/payment/{id}")
	Payment getPayment(@PathVariable String id) {
		return paymentService.getPaymentById(id);
	}
	
	@PostMapping("/payment")
	Payment newPayment(@RequestBody Payment payment) {
		return paymentService.newPayment(payment);
	}
}
