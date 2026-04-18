package com.example.tripfusion.bookingRequest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.tripfusion.busdetails.BusDetails;
import com.example.tripfusion.busdetails.BusDetailsRepository;
import com.example.tripfusion.response.ApiResponse;
import com.example.tripfusion.users.Users;
import com.example.tripfusion.users.UsersRepository;

import jakarta.transaction.Transactional;

@Service
public class BookingRequestService {

	@Autowired
	BusDetailsRepository busDetailsRepository;

	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	BookingRequestRepository bookingRequestRepository;
	
	@Transactional
	public ResponseEntity<ApiResponse> addBooking(BookingRequestDto bookingRequestDto){
		
		BookingRequest savedBookingRequest=null;
		
		if (bookingRequestDto.getId() != null) {
			savedBookingRequest = bookingRequestRepository.getById(bookingRequestDto.getId());
		}
		if (savedBookingRequest == null) {
			savedBookingRequest = new BookingRequest();
			savedBookingRequest.setCreatedAt(LocalDateTime.now());
		}
		// Check availability: if any CONFIRMED booking for the same bus overlaps requested range, reject
		if (bookingRequestDto.getFromDate() != null && bookingRequestDto.getToDate() != null && bookingRequestDto.getBusId() != null) {
			List<BookingRequest> conflicts = bookingRequestRepository.findConfirmedBookingsForBusBetween(
					bookingRequestDto.getBusId(), bookingRequestDto.getFromDate(), bookingRequestDto.getToDate());
			if (conflicts != null && !conflicts.isEmpty()) {
				return ResponseEntity.ok(new ApiResponse(409, "Fail", "Bus is not available for the selected dates", null));
			}
		}
		savedBookingRequest.setFromDate(bookingRequestDto.getFromDate());
		savedBookingRequest.setToDate(bookingRequestDto.getToDate());
		savedBookingRequest.setMessage(bookingRequestDto.getMessage());
		savedBookingRequest.setStatus(bookingRequestDto.getStatus());
		savedBookingRequest.setQuotedPrice(bookingRequestDto.getQuotedPrice());
		savedBookingRequest.setPlace(bookingRequestDto.getPlace());
		savedBookingRequest.setUpdatedAt(LocalDateTime.now());
		Users user = usersRepository.getById(bookingRequestDto.getUserId());
		savedBookingRequest.setUser(user);
		BusDetails busDetails=busDetailsRepository.getById(bookingRequestDto.getBusId());
		savedBookingRequest.setBus(busDetails);
		
		try {
			BookingRequest saved = bookingRequestRepository.save(savedBookingRequest);
			return ResponseEntity.ok(new ApiResponse(200, "Sucess", "Booking Details Saved Sucessfull", saved));
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse(400, "Fail", e.getMessage(), null));
		}
	}

	public ResponseEntity<ApiResponse> getBookingById(Long bookingId) {
		BookingRequest saved=bookingRequestRepository.getById(bookingId);
		if(saved !=null) {
			return ResponseEntity.ok(new ApiResponse(200,"Sucess",saved));
		}
		else {
			return ResponseEntity.ok(new ApiResponse(404,"Fail","Booking Details Not Found"));
		}
	}
}
