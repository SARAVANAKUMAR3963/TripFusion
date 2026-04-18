package com.example.tripfusion.busdetails;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.tripfusion.response.ApiResponse;
import com.example.tripfusion.users.Users;
import com.example.tripfusion.users.UsersRepository;

import jakarta.transaction.Transactional;

@Service
public class BusDetailsService {

	@Autowired
	BusDetailsRepository busDetailsRepository;

	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	BusImageRepository imageRepository;

	@Transactional
	public ResponseEntity<ApiResponse> saveBus(BusDetailsRequest busDetailsRequest) {
		BusDetails savedBusDetails = null;
		if (busDetailsRequest.getId() != null) {
			savedBusDetails = busDetailsRepository.getById(busDetailsRequest.getId());
		}
		if (savedBusDetails == null) {
			savedBusDetails = new BusDetails();
			savedBusDetails.setCreatedAt(LocalDateTime.now());
		}
		savedBusDetails.setTransportName(busDetailsRequest.getTransportName());
		savedBusDetails.setBusNmae(busDetailsRequest.getBusNmae());
		savedBusDetails.setDescription(busDetailsRequest.getDescription());
		savedBusDetails.setSpecification(busDetailsRequest.getSpecification());
		savedBusDetails.setBusNo(busDetailsRequest.getBusNo());
		savedBusDetails.setRent(busDetailsRequest.getRent());
		savedBusDetails.setSeatingCapacity(busDetailsRequest.getSeatingCapacity());
		savedBusDetails.setRating(busDetailsRequest.getRating());
		savedBusDetails.setApproximatryCostPerDay(busDetailsRequest.getApproximatryCostPerDay());
		savedBusDetails.setUpdatedAt(LocalDateTime.now());
		Users user = usersRepository.getById(busDetailsRequest.getUserId());
		savedBusDetails.setOwner(user);
		savedBusDetails.getImages().clear(); 
		if (busDetailsRequest.getImages() != null && !busDetailsRequest.getImages().isEmpty()) {
			for (BusImage file : busDetailsRequest.getImages()) {
				BusImage img = new BusImage();
				img.setImage(file.getImage());
				img.setImageName(file.getImageName());
				img.setImageFormat(file.getImageFormat());
				savedBusDetails.addImage(img);
			}
		}

		try {
			BusDetails saved = busDetailsRepository.save(savedBusDetails);
			return ResponseEntity.ok(new ApiResponse(200, "Sucess", "Bus Details Saved Sucessfull", saved));
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse(400, "Fail", e.getMessage(), null));
		}

	}
	
	@Transactional
	public void addImage(Long busId, MultipartFile file) throws IOException {

	    BusDetails bus = busDetailsRepository.findById(busId)
	            .orElseThrow(() -> new RuntimeException("Bus not found"));

	    BusImage image = new BusImage();
	    image.setImage(file.getBytes());
	    image.setImageName(file.getOriginalFilename());
	    image.setImageFormat(file.getContentType());

	    bus.addImage(image);

	    busDetailsRepository.save(bus); // cascade saves image
	}
	
	@Transactional
	public void removeImage(Long imageId) {

	    BusImage image = imageRepository.findById(imageId)
	            .orElseThrow(() -> new RuntimeException("Image not found"));

	    BusDetails bus = image.getBus();

	    bus.removeImage(image); // orphanRemoval = true handles delete
	}
	
	public ResponseEntity<ApiResponse> getBusById(Long id) {

	    BusDetails bus = busDetailsRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Bus not found"));

	    return ResponseEntity.ok(
	            new ApiResponse(200, "Success", "Bus fetched successfully", bus)
	    );
	}

	public ResponseEntity<ApiResponse> getAllBuses() {

	    List<BusDetails> buses = busDetailsRepository.findAll();

	    return ResponseEntity.ok(
	            new ApiResponse(200, "Success", "Bus list fetched", buses)
	    );
	}




}
