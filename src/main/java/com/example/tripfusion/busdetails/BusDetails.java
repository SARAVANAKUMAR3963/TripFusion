package com.example.tripfusion.busdetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.tripfusion.users.Users;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="BusDetails")
public class BusDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@Column(name = "createdAt", columnDefinition = "DATETIME")
	LocalDateTime createdAt;
	
	@Column(name = "updatedAt", columnDefinition = "DATETIME")
	LocalDateTime updatedAt;
	
	
	@ManyToOne
    @JoinColumn(name = "admin_id") 
    private Users owner;
	
	@OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BusImage> images = new ArrayList<>();
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}


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

	public Users getOwner() {
		return owner;
	}

	public void setOwner(Users owner) {
		this.owner = owner;
	}

	public List<BusImage> getImages() {
		return images;
	}

	public void addImage(BusImage image) {
	    images.add(image);
	    image.setBus(this);
	}

	public void removeImage(BusImage image) {
	    images.remove(image);
	    image.setBus(null);
	}

	
	

}
