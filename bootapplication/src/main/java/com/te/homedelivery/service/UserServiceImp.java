package com.te.homedelivery.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.homedelivery.dto.UserDto;
import com.te.homedelivery.exception.UserNotFoundException;
import com.te.homedelivery.pojo.UserDetails;
import com.te.homedelivery.repository.UserRepo;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	UserRepo repo;
	@Autowired
	UserDetails userDetails;

	

	@Override
	public UserDto save(UserDto userDto) {
		UserDetails userDetails = this.dtoToUser(userDto);
		UserDetails save = this.repo.save(userDetails);
		return this.userToDto(save);
	}
	
	@Override
	public UserDto update(UserDto userDto, Integer id) {
		Optional<UserDetails> findById = this.repo.findById(id);
		if (findById.isPresent()) {
			UserDetails userDetails2 = this.dtoToUser(userDto);
			UserDto userToDto = this.userToDto(userDetails2);
			UserDto save = this.save(userToDto);
			return save;
		}
		return new UserDto();
	}

	@Override
	public List<UserDto> findAll() {
		List<UserDetails> users = repo.findAll();
		List<UserDto> findAll = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return findAll;
		}
	
	@Override
	public UserDto finduser(Integer id) {
		 UserDetails userDetails2 = repo.findById(id).orElseThrow(()->new UserNotFoundException("user not found"));
		UserDto userToDto = userToDto(userDetails2);
		return userToDto;
	}
	
	
	@Override
	public void delete(Integer id) {
       UserDetails user = repo.findById(id).orElseThrow(()->new UserNotFoundException("User not found"));
       this.repo.delete(user);
	}
	
	public UserDetails dtoToUser(UserDto userDto) {
		UserDetails userDetails2 = new UserDetails();
		userDetails2.setAddress(userDto.getAddress());
		userDetails2.setContactNo(userDto.getContactNo());
		userDetails2.setDeliveryPartner(userDto.getDeliveryPartner());
		userDetails2.setEmailId(userDto.getEmailId());
		userDetails2.setUserName(userDto.getUserName());
		return userDetails2;
	}

	public UserDto userToDto(UserDetails userDetails) {
		UserDto userDto = new UserDto();
		userDto.setAddress(userDetails.getAddress());
		userDto.setContactNo(userDetails.getContactNo());
		userDto.setDeliveryPartner(userDetails.getDeliveryPartner());
		userDto.setEmailId(userDetails.getEmailId());
		userDto.setUserName(userDetails.getUserName());
		return userDto;
	}

	@Override
	public UserDetails getUser(Integer id) {
		Optional<UserDetails> findById = repo.findById(id);
		return findById.get();
	}




}
