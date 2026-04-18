package com.example.tripfusion.bookingRequest;

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
@RequestMapping("api/bookingrequest")
public class BookingRequestController {
	
	@Autowired
	BookingRequestService bookingRequestService;
	
	@PostMapping("/add-booking")
	public ResponseEntity<ApiResponse> addBooking(@RequestBody BookingRequestDto bookingRequestDto){
		return bookingRequestService.addBooking(bookingRequestDto);
	}
	
	@GetMapping("/get-booking/{bookingId}")
	public ResponseEntity<ApiResponse> getBookingById(@PathVariable Long bookingId){
		return bookingRequestService.getBookingById(bookingId);
	}

}
