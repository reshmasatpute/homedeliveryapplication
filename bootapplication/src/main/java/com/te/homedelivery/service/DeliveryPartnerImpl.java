package com.te.homedelivery.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.homedelivery.dto.DeliveryPartnerDto;
import com.te.homedelivery.exception.DeliveryPartnerIsNotFoundException;
import com.te.homedelivery.pojo.DeliveryPartner;
import com.te.homedelivery.repository.DeliveryPartnerRepository;

@Service
public class DeliveryPartnerImpl implements DeliveryPartnerService {

	@Autowired
	DeliveryPartnerRepository repo;
	
	@Override
	public DeliveryPartnerDto saveDeliveryPartner(DeliveryPartnerDto deliveryPartnerDto) {
		DeliveryPartner dtoToDeliveryPartner = this.dtoToDeliveryPartner(deliveryPartnerDto);
		DeliveryPartner save = repo.save(dtoToDeliveryPartner);
		return this.partnerToDto(save);
	}

		
	@Override
	public List<DeliveryPartnerDto> findAll() {
		List<DeliveryPartner> deliveryPartners = repo.findAll();
		List<DeliveryPartnerDto> getAll = deliveryPartners.stream().map(deliveryPartner -> this.partnerToDto(deliveryPartner)).collect(Collectors.toList());
		return getAll;
	}
	
	
	@Override
	public DeliveryPartnerDto update(DeliveryPartnerDto deliveryPartnerDto, Integer id) {
		Optional<DeliveryPartner> findById = repo.findById(id);
		if (findById.isPresent()) {
			DeliveryPartner deliveryPartner = this.dtoToDeliveryPartner(deliveryPartnerDto);
			deliveryPartner.setAvailable_From(deliveryPartnerDto.getAvailable_From());
			deliveryPartner.setAvailable_to(deliveryPartnerDto.getAvailable_to());
			deliveryPartner.setDeliveryPartnerName(deliveryPartnerDto.getDeliveryPartnerName());
			deliveryPartner.setLocation(deliveryPartnerDto.getLocation());
			deliveryPartner.setRating(deliveryPartnerDto.getRating());
			deliveryPartner.setTime(deliveryPartnerDto.getTime());
			deliveryPartner.setUserDetails(deliveryPartnerDto.getUserDetails());
			DeliveryPartner save = repo.save(deliveryPartner);
			return  this.partnerToDto(save);
		} 
		return new DeliveryPartnerDto();
	}
	
	
	
	@Override
	public void delete(Integer id) {
		DeliveryPartner deliveryPartner = repo.findById(id).orElseThrow(()-> new DeliveryPartnerIsNotFoundException("Delivery partner is not found"));
		this.repo.delete(deliveryPartner);
	}
	
	
	
	

	
	
	
	public DeliveryPartnerDto partnerToDto(DeliveryPartner deliveryPartner) {
		DeliveryPartnerDto deliveryPartnerDto = new DeliveryPartnerDto();
		deliveryPartnerDto.setAvailable_From(deliveryPartner.getAvailable_From());
		deliveryPartner.setAvailable_to(deliveryPartnerDto.getAvailable_to());
		deliveryPartner.setDeliveryPartnerName(deliveryPartnerDto.getDeliveryPartnerName());
		deliveryPartner.setLocation(deliveryPartnerDto.getLocation());
		deliveryPartner.setRating(deliveryPartnerDto.getRating());
		deliveryPartner.setTime(deliveryPartnerDto.getTime());
		deliveryPartner.setUserDetails(deliveryPartnerDto.getUserDetails());
		return deliveryPartnerDto;
	}
	
	public DeliveryPartner dtoToDeliveryPartner(DeliveryPartnerDto deliveryPartnerDto) {
		DeliveryPartner deliveryPartner = new DeliveryPartner();
		deliveryPartner.setAvailable_From(deliveryPartnerDto.getAvailable_From());
		deliveryPartner.setAvailable_to(deliveryPartnerDto.getAvailable_to());
		deliveryPartner.setDeliveryPartnerName(deliveryPartnerDto.getDeliveryPartnerName());
		deliveryPartner.setLocation(deliveryPartnerDto.getLocation());
		deliveryPartner.setRating(deliveryPartnerDto.getRating());
		deliveryPartner.setTime(deliveryPartnerDto.getTime());
		deliveryPartner.setUserDetails(deliveryPartnerDto.getUserDetails());
		return deliveryPartner;
	}













	
	
	
	
	
	
	
	
}
