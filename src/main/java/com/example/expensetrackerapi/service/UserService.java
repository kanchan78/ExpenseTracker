package com.example.expensetrackerapi.service;

import com.example.expensetrackerapi.entity.User;
import com.example.expensetrackerapi.entity.UserModel;

public interface UserService {

	User createUser(UserModel user);

	User read(Long id);

	User update(User user, Long id);

	void delete(Long id);
	
	User getLoggedInUser();
}
