package com.te.homedelivery.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.homedelivery.constant.DeliveryPartnerConstant;
import com.te.homedelivery.dto.DeliveryPartnerDto;
import com.te.homedelivery.response.DeliveryPartnerResponse;
import com.te.homedelivery.service.DeliveryPartnerService;

@RestController
@RequestMapping("/api/partner")
public class DeliveryPartnerController {

	
	DeliveryPartnerService service;

	@PostMapping("/save-delivery-partner")
	public ResponseEntity<DeliveryPartnerResponse> save(@RequestBody DeliveryPartnerDto deliveryPartnerDto) {
		DeliveryPartnerDto saveDeliveryPartner = service.saveDeliveryPartner(deliveryPartnerDto);
		if (saveDeliveryPartner != null) {
			return ResponseEntity.ok(new DeliveryPartnerResponse(Boolean.FALSE, DeliveryPartnerConstant.DELIVERY_PARNER_CREATED_SUCCESSFULLY,
					deliveryPartnerDto));
		} else {
			return ResponseEntity.ok(new DeliveryPartnerResponse(Boolean.TRUE, DeliveryPartnerConstant.CREATION_FAILURE, saveDeliveryPartner));
		}

	}

	@GetMapping("/find-all-deliverypartner")
	public ResponseEntity<DeliveryPartnerResponse> findAll() {
		List<DeliveryPartnerDto> findAll = service.findAll();
		if (findAll != null) {
			return ResponseEntity.ok(new DeliveryPartnerResponse(Boolean.FALSE, DeliveryPartnerConstant.GET_ALL_SUCCESSFULL, findAll));

		} else {
			return ResponseEntity.ok(new DeliveryPartnerResponse(Boolean.TRUE, DeliveryPartnerConstant.GET_ALL_FAILURE, findAll));
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<DeliveryPartnerResponse> update(@RequestBody DeliveryPartnerDto deliveryPartnerDto,
			@PathVariable Integer id) {
		DeliveryPartnerDto update = service.update(deliveryPartnerDto, id);
		if (update != null) {
			return ResponseEntity.ok(new DeliveryPartnerResponse(Boolean.FALSE, DeliveryPartnerConstant.UPDATE_SUCCESSFULLY, update));

		} else {
			return ResponseEntity.ok(new DeliveryPartnerResponse(Boolean.TRUE, DeliveryPartnerConstant.UPDATE_FAILURE, update));
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<DeliveryPartnerResponse> delete(@RequestParam Integer id) {
		if (id != null) {
			service.delete(id);
			return ResponseEntity
					.ok(new DeliveryPartnerResponse(Boolean.FALSE, DeliveryPartnerConstant.DELIVERY_PARTNER_DELETED_SUCCESSFULLY, id));

		} else {
           return ResponseEntity
					.ok(new DeliveryPartnerResponse(Boolean.TRUE, DeliveryPartnerConstant.DELETION_FAILURE, id));
		}
	}

}
