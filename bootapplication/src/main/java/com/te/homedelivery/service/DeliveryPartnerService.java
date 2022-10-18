package com.te.homedelivery.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.te.homedelivery.dto.DeliveryPartnerDto;

public interface DeliveryPartnerService {

	public DeliveryPartnerDto saveDeliveryPartner(@RequestBody DeliveryPartnerDto deliveryPartnerDto);
	
	public List<DeliveryPartnerDto> findAll();
	
	public DeliveryPartnerDto update( DeliveryPartnerDto deliveryPartnerDto,Integer id);
		
	public void delete(Integer id) ;
	
	
	
	
	
	
	
	
}
