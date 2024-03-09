package com.example.expensetrackerapi.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserModel {

	@NotBlank(message = "Please enter name")
	private String name;
	
	@NotNull(message = "Please Enter email")
	@Email(message = "Please Enter valid email")
	private String email;
	
	@NotNull(message = "Please Enter password")
	@Size(min = 5, message = "Password should be atlease 5 characters")
	private String password;
	private Long age = 0L;
}
