package com.te.homedelivery.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.te.homedelivery.pojo.DeliveryPartner;
import com.te.homedelivery.pojo.Product;
import com.te.homedelivery.pojo.UserAddress;

import lombok.Data;

@Component
@Data
public class UserDto {
	private int id;
	private List<Product> productId;
	private String userName;
	private long contactNo;
	private String emailId;

	private List<UserAddress> address;

	private List<DeliveryPartner> deliveryPartner;

}
