//package com.example.expensetrackerapi.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.expensetrackerapi.entity.User;
//import com.example.expensetrackerapi.entity.UserModel;
//import com.example.expensetrackerapi.service.UserService;
//
//import jakarta.validation.Valid;
//
//@RestController
//public class UserController {
//
//	@Autowired
//	private UserService userService;
//	
//	@PostMapping("/register")
//	public ResponseEntity<User>save(@Valid @RequestBody UserModel user){
//		return new ResponseEntity<User>(userService.createUser(user),HttpStatus.CREATED);
//		
//	}
//	
//	@GetMapping("/users/{id}")
//	public ResponseEntity<User> findUser(@PathVariable Long id){
//		return new ResponseEntity<User>(userService.read(id),HttpStatus.OK);
//	}
//	
//	@PutMapping("/users/{id}")
//	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id){
//		
//		return new ResponseEntity<User>(userService.update(user, id),HttpStatus.OK);
//		
//	}
//	
//	@DeleteMapping("/users/{id}")
//	public ResponseEntity<User> deleteUser(@PathVariable Long id){
//		userService.delete(id);
//		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//	}
//}
