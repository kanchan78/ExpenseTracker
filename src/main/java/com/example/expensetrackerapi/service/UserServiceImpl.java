//package com.example.expensetrackerapi.service;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.example.expensetrackerapi.entity.User;
//import com.example.expensetrackerapi.entity.UserModel;
//import com.example.expensetrackerapi.exceptions.ItemAlreadyExistsException;
//import com.example.expensetrackerapi.exceptions.ResourceNotFoundException;
//import com.example.expensetrackerapi.repository.UserRepository;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	@Override
//	public User createUser(UserModel user) {
//		if (userRepository.existsByEmail(user.getEmail())) {
//			throw new ItemAlreadyExistsException("User is already registered with email " + user.getEmail());
//		}
//		User newUser = new User();
//		BeanUtils.copyProperties(user, newUser);
//		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
//		return userRepository.save(newUser);
//
//	}
//
//	@Override
//	public User read(Long id) {
//
//		return userRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("User not found for the id: " + id));
//	}
//
//	@Override
//	public User update(User user, Long id) {
//		User updatedUser = read(id);
//		if (user.getName() != null) {
//			updatedUser.setName(user.getName());
//		}
//		if (user.getEmail() != null) {
//			updatedUser.setEmail(user.getEmail());
//		}
//
//		if (user.getAge() != null) {
//			updatedUser.setAge(user.getAge());
//		}
//
//		if (user.getPassword() != null) {
//			updatedUser.setPassword(passwordEncoder.encode(user.getPassword()));
//		}
//
//		return userRepository.save(updatedUser);
//
//	}
//
//	@Override
//	public void delete(Long id) {
//
//		User user = read(id);
//
//		userRepository.delete(user);
//
//	}
//
//	@Override
//	public User getLoggedInUser() {
//
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String email = authentication.getName();
//		return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User Not found for "+email));
//	}
//}
