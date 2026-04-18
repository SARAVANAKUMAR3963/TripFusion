package com.example.tripfusion.busdetails;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.tripfusion.response.ApiResponse;
import com.example.tripfusion.users.UserRequest;

@RestController
@RequestMapping("api/busdetails")
public class BusDetailsController {
	
	@Autowired
	BusDetailsService busDetailsService;
	
	@PostMapping("/add-bus")
	public ResponseEntity<ApiResponse> addBus(@RequestBody BusDetailsRequest buDetailsRequest){
		return busDetailsService.saveBus(buDetailsRequest);
	}
	
	@PostMapping("/bus/{busId}/image")
	public ResponseEntity<?> addImage(
	        @PathVariable Long busId,
	        @RequestParam MultipartFile image) throws IOException {

	    busDetailsService.addImage(busId, image);
	    return ResponseEntity.ok("Image added successfully");
	}

	@DeleteMapping("/bus/image/{imageId}")
	public ResponseEntity<?> deleteImage(@PathVariable Long imageId) {

	    busDetailsService.removeImage(imageId);
	    return ResponseEntity.ok("Image deleted successfully");
	}

	@GetMapping("/bus/{id}")
	public ResponseEntity<ApiResponse> getBusById(@PathVariable Long id) {
	    return busDetailsService.getBusById(id);
	}

	@GetMapping("/buses")
	public ResponseEntity<ApiResponse> getAllBuses() {
	    return busDetailsService.getAllBuses();
	}

}
