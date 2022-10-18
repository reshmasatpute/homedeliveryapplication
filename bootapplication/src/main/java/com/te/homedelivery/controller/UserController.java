package com.te.homedelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.te.homedelivery.constant.UserConstant;
import com.te.homedelivery.dto.UserDto;
import com.te.homedelivery.pojo.UserDetails;
import com.te.homedelivery.response.UserResponse;
import com.te.homedelivery.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	
	@Autowired
	UserService service;

	@PostMapping("/save")
	public ResponseEntity<UserResponse> save(@RequestBody UserDto userDto) {
		UserDto save2 = this.service.save(userDto);
		if (save2!=null) {
			return ResponseEntity.ok(new UserResponse(Boolean.FALSE, UserConstant.USER_CREATED_SUCCESSFULLY, save2));
		} else {
             return ResponseEntity.ok(new UserResponse(Boolean.TRUE, UserConstant.CREATION_FAILURE, save2));
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserResponse> update(@RequestBody UserDto userDto, @PathVariable Integer id) {
		UserDto update = this.service.update(userDto, id);
		if (update!=null) {
			return ResponseEntity.ok(new UserResponse(Boolean.FALSE, UserConstant.USER_UPDATED_SUCCESSFULL, update));
		} else {
			return ResponseEntity.ok(new UserResponse(Boolean.TRUE, UserConstant.UPDATION_FAILURE, update));

		}
	}

	@GetMapping("/findAll")
	public ResponseEntity<UserResponse> findAll() {
		List<UserDto> findAll = service.findAll();
		if (findAll!=null) {
			return ResponseEntity.ok(new UserResponse(Boolean.FALSE, UserConstant.GET_ALL_SUCCESSFULL, findAll));
			
		} else {
			
			return ResponseEntity.ok(new UserResponse(Boolean.TRUE, UserConstant.GET_ALL_FAILURE, findAll));

		}

	}
	
	@GetMapping("/findById")
	public ResponseEntity<UserResponse> findById(@RequestParam Integer id) {
		UserDto findById = service.finduser(id);
		if (findById!=null) {
			
			return ResponseEntity.ok(new UserResponse(Boolean.FALSE, UserConstant.FIND_BY_ID_SUCCESSFULL, findById));
		} else {
			return ResponseEntity.ok(new UserResponse(Boolean.TRUE, UserConstant.FIND_BY_ID_FAILURE, findById));
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<UserResponse> delete(@RequestParam Integer id) {
		if (id!=null) {
			service.delete(id);
			return ResponseEntity.ok(new UserResponse(Boolean.FALSE, UserConstant.USER_DELETED, id));
			
		} else {
			return ResponseEntity.ok(new UserResponse(Boolean.TRUE,UserConstant. USER_DELETION_FAILURE, id));

		}
	}
	
	@GetMapping("/get")
	public ResponseEntity<UserResponse> getUser(@RequestParam Integer id){
		UserDetails user = service.getUser(id);
		if (user!=null) {
			return ResponseEntity.ok(new UserResponse(Boolean.FALSE, UserConstant.GET_USER_SUCCESSFULL, user));
		} else {
			return ResponseEntity.ok(new UserResponse(Boolean.TRUE, UserConstant.GET_USER_FAILURE, user));

		}
		
	}
	
	
	
	
	

}
