package com.example.tripfusion.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tripfusion.response.ApiResponse;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/add-user")
	public ResponseEntity<ApiResponse> addUsers(@RequestBody UserRequest user){
		return userService.saveUser(user);
	}
	
	@GetMapping("get-user/{id}")
	public ResponseEntity<ApiResponse> getUser(@PathVariable Long id){
		return userService.getUser(id);
	}

}
