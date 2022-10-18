package com.te.homedelivery.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> productId;
	private String userName;
	private long contactNo;
	private String emailId;

	@OneToMany(cascade = CascadeType.ALL)
	private List<UserAddress> address;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<DeliveryPartner> deliveryPartner;
}
