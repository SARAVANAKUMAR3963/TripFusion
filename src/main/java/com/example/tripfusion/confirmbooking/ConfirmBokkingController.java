package com.example.tripfusion.confirmbooking;

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
@RequestMapping("/api/confirmBooking")
public class ConfirmBokkingController {
	
	@Autowired
	ConfirmBookingService confirmBookingService;
	
	@PostMapping("/add-confirmBooking")
	public ResponseEntity<ApiResponse> addConfirmBooking(@RequestBody ConfirmBookingRequest confirmBookingRequest){
		return confirmBookingService.addConfirmBooking(confirmBookingRequest);
	}
	
	@GetMapping("/get-confirmBooking/{confirmBookingId}")
	public ResponseEntity<ApiResponse> getConfirmBooking(@PathVariable Long confirmBookingId){
		return confirmBookingService.getConfirmBooking(confirmBookingId);
	}

}
