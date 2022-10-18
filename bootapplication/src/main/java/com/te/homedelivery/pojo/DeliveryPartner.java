package com.te.homedelivery.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
public class DeliveryPartner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deliveryPartnerId;
	private String available_From;
	private String available_to;
	private String time;
	private String deliveryPartnerName;
	private String location;
	private int rating;
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "deliveryPartner")
	private List<UserDetails> userDetails;
}
