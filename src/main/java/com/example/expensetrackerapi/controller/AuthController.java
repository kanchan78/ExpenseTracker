//package com.example.expensetrackerapi.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.expensetrackerapi.entity.LoginModel;
//import com.example.expensetrackerapi.entity.User;
//import com.example.expensetrackerapi.entity.UserModel;
//import com.example.expensetrackerapi.service.UserService;
//
//import jakarta.validation.Valid;
//
//@RestController
//public class AuthController {
//
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@Autowired
//	private UserService userService;
//
//	@PostMapping("/login")
//	public ResponseEntity<HttpStatus> login(@RequestBody LoginModel loginModel) {
//		org.springframework.security.core.Authentication authentication = authenticationManager
//				.authenticate(new UsernamePasswordAuthenticationToken(loginModel.getEmail(), loginModel.getPassword()));
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
//	}
//
//	@PostMapping("/signup")
//	public ResponseEntity<User> register(@Valid @RequestBody UserModel user) {
//		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
//	}
//}
