package com.user.user.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.user.model.User;
import com.user.user.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUsers = userService.getAllUsers();
		if(allUsers==null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(allUsers);	
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") long uid){
		Optional<User> findUserById = userService.findUserById(uid);
		if(findUserById==null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(findUserById);
		
	}
	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") long uid){
		userService.deleteUser(uid);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User addUser = userService.addUser(user);
		if(addUser==null)
		{
			return ResponseEntity.notFound().build();
		}
		return  ResponseEntity.ok(addUser);
		
	}
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long uid, @Valid @RequestBody User user){
		User updateuser = userService.updateuser(uid, user);
		if(updateuser==null)
		{
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updateuser);
		
	}

}
