package com.product.orderManagement.api;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.product.orderManagement.dto.UsersDTO;
import com.product.orderManagement.entity.UsersEntity;

import jakarta.validation.Valid;

public interface UsersAPI {

	@PostMapping("/api/createUsers")
	ResponseEntity<UsersEntity> createUsers(@RequestBody @Valid UsersDTO usersDTO);

	@PostMapping("/api/login")
	String userLogin(@RequestBody @Valid Map<String, Object> loginUserData);

}
