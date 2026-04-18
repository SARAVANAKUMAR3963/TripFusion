package com.example.tripfusion.busdetails;

import java.util.ArrayList;
import java.util.List;

import com.example.tripfusion.users.Users;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class BusDetailsRequest {
	
private Long id;
	
	String transportName;
	
	String busNmae;
	
	String description;
	
	String specification;
	
	String busNo;
	
	Double rent;
	
	Integer seatingCapacity;
	
	Double rating;
	
	Double approximatryCostPerDay;
	
    private Long userId;
    
    private List<BusImage> images;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTransportName() {
		return transportName;
	}

	public void setTransportName(String transportName) {
		this.transportName = transportName;
	}

	public String getBusNmae() {
		return busNmae;
	}

	public void setBusNmae(String busNmae) {
		this.busNmae = busNmae;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

	public Integer getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(Integer seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Double getApproximatryCostPerDay() {
		return approximatryCostPerDay;
	}

	public void setApproximatryCostPerDay(Double approximatryCostPerDay) {
		this.approximatryCostPerDay = approximatryCostPerDay;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<BusImage> getImages() {
		return images;
	}

	public void setImages(List<BusImage> images) {
		this.images = images;
	}
    
    

}
