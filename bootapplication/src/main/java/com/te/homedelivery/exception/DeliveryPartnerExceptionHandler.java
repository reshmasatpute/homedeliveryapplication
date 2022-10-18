package com.te.homedelivery.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.homedelivery.response.DeliveryPartnerResponse;

@ControllerAdvice
public class DeliveryPartnerExceptionHandler {

	@ExceptionHandler(DeliveryPartnerIsNotFoundException.class)
	public ResponseEntity<DeliveryPartnerResponse> deliveryPartnerNotFound(DeliveryPartnerIsNotFoundException exception){
		return ResponseEntity.ok(new DeliveryPartnerResponse(true, exception.getMessage(),null));
		
	}
	
	
	
	
}
