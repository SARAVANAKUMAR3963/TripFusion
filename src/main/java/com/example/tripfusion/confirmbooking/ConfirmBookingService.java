package com.example.tripfusion.confirmbooking;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tripfusion.bookingRequest.BookingRequest;
import com.example.tripfusion.bookingRequest.BookingRequestRepository;
import com.example.tripfusion.response.ApiResponse;

@Service
public class ConfirmBookingService {
	
	@Autowired
	ConfirmBookingRepository confirmBookingRepository;
	
	@Autowired
	BookingRequestRepository bookingRequestRepository;
	
	@Transactional
	public ResponseEntity<ApiResponse> addConfirmBooking(ConfirmBookingRequest confirmBookingRequest){
		
		ConfirmBooking confirmBooking=null;
		
		if(confirmBookingRequest.getId() !=null) {
			confirmBooking=confirmBookingRepository.getById(confirmBookingRequest.getId());
		}
		if(confirmBooking==null) {
			confirmBooking=new ConfirmBooking();
			confirmBooking.setCreatedAt(LocalDateTime.now());
		}
		confirmBooking.setFinalAmount(confirmBookingRequest.getFinalAmount());
		confirmBooking.setAdvanceAmount(confirmBookingRequest.getAdvanceAmount());
		confirmBooking.setBalanceAmount(confirmBookingRequest.getBalanceAmount());
		// set status from request
		confirmBooking.setStatus(confirmBookingRequest.getStatus());
		confirmBooking.setUpdatedAt(LocalDateTime.now());
		BookingRequest bookingRequest=bookingRequestRepository.getById(confirmBookingRequest.getBookingRequestId());
		confirmBooking.setBookingRequest(bookingRequest);
		
		try {
			ConfirmBooking saved = confirmBookingRepository.save(confirmBooking);
			// mark linked booking request as CONFIRMED so the bus becomes unavailable for that period
			try {
				bookingRequest.setStatus("CONFIRMED");
				bookingRequest.setUpdatedAt(LocalDateTime.now());
				bookingRequestRepository.save(bookingRequest);
			} catch (Exception ex) {
				// ignore secondary save errors here; primary confirm saved
			}
			return ResponseEntity.ok(new ApiResponse(200, "Sucess", "Confirm Booking Saved Sucessfull", saved));
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse(400, "Fail", e.getMessage(), null));
		}
	
	}

	public ResponseEntity<ApiResponse> getConfirmBooking(Long confirmBookingId) {
		ConfirmBooking saved=confirmBookingRepository.getById(confirmBookingId);
		if(saved !=null) {
			return ResponseEntity.ok(new ApiResponse(200,"Sucess",saved));
		}
		else {
			return ResponseEntity.ok(new ApiResponse(404,"Fail","ConfirmBooking Not Found"));
		}
	}

}
