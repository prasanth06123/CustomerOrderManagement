package com.product.orderManagement.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@lombok.Data
@Builder
public class UsersDTO {

	private Long id;

	@NotEmpty(message = "First Name cannot be empty")
	@Size(min = 5, max = 100, message = "First Name must be at least 5 characters and should not exceed 100 characters")
	private String firstName;

	@NotEmpty(message = "Last Name cannot be empty")
	@Size(min = 1, max = 100, message = "Last Name must be at least 1 characters and should not exceed 100 characters")
	private String lastName;

	@NotEmpty(message = "Password cannot be empty")
	@Size(min = 5, max = 100, message = "Password must be at least 5 characters and should not exceed 100 characters")
	private String password;

	@NotEmpty(message = "Mobile Number cannot be empty")
	@Size(min = 10, max = 10, message = "Mobile Number must be 10 characters")
	private String mobileNumber;

	@NotEmpty(message = "Email Address cannot be empty")
	@Size(min = 5, max = 100, message = "Email Address must be 10 characters")
	private String emailAddress;

}
