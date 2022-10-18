package com.te.homedelivery.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Component;

import com.te.homedelivery.pojo.UserDetails;

import lombok.Data;

@Data
@Component
public class DeliveryPartnerDto {
	private int id;
	private String available_From;
	private String available_to;
	private String time;
	private String deliveryPartnerName;
	private String location;
	private int rating;
	private List<UserDetails> userDetails;
}
