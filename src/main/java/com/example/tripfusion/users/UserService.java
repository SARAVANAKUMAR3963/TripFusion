package com.example.tripfusion.users;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.tripfusion.response.ApiResponse;

@Service
public class UserService {
	
	@Autowired
	UsersRepository usersRepository;
	
	public ResponseEntity<ApiResponse> saveUser(UserRequest user) {
		Users savedUser=null;
		if(user.getId()!=null) {
			savedUser=usersRepository.getById(user.getId());
		}
		if(savedUser==null) {
			savedUser=new Users();
			savedUser.setCreatedAt(LocalDateTime.now(ZoneOffset.UTC));
		}
		savedUser.setName(user.getName());
		savedUser.setPhoneNo(user.getPhoneNo());
		savedUser.setEmailId(user.getEmailId());
		savedUser.setAddress(user.getAddress());
		savedUser.setCity(user.getCity());
		savedUser.setPassword(user.getPassword());
		savedUser.setUpdatedAt(LocalDateTime.now(ZoneOffset.UTC));
		try {
			Users saved=usersRepository.save(savedUser);
			return ResponseEntity.ok(new ApiResponse(200,"Sucess","User Saved Sucessfull",saved));
		}
		catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse(400,"Fail",e.getMessage(),null));
		}
	}
	
	public ResponseEntity<ApiResponse> getUser(Long id) {
		Users savedUser=usersRepository.getById(id);
		if(savedUser !=null) {
			return ResponseEntity.ok(new ApiResponse(200,"Sucess",savedUser));
		}
		else {
			return ResponseEntity.ok(new ApiResponse(204,"Fail","User Not Found"));
		}
	}

}
