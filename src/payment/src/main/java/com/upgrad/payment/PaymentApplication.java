package com.upgrad.payment;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class PaymentApplication {

	public static void main(String[] args) {

		SpringApplication.run(PaymentApplication.class, args);
		System.out.println("Payment service started");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
