package com.te.homedelivery.service;

import java.util.List;

import com.te.homedelivery.dto.UserDto;
import com.te.homedelivery.pojo.UserDetails;

public interface UserService {
	
	public UserDto save(UserDto userDto);
	
	public UserDto update(UserDto userDto ,Integer id);
	
	public List<UserDto> findAll();
	
	public UserDto finduser(Integer id);
	
	public void delete(Integer id);
	
	public UserDetails getUser(Integer id);
	
	
	
	
	
	
}


