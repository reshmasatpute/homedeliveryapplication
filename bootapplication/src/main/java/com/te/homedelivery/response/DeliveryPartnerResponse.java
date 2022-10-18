package com.te.homedelivery.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryPartnerResponse {
	private boolean isError;
	private String message;
	private Object data;
}
