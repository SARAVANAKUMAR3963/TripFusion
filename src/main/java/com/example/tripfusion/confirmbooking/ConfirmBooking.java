package com.example.tripfusion.confirmbooking;

import java.time.LocalDateTime;

import jakarta.persistence.Id;

import com.example.tripfusion.bookingRequest.BookingRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ConfirmBooking")
public class ConfirmBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	Double finalAmount;
	
	Double advanceAmount;
	
	Double balanceAmount;
	
	String status;
	
	@OneToOne
	@JoinColumn(name = "bookingRequest_id", nullable = false)
	BookingRequest bookingRequest;
	
	@Column(name = "createdAt", columnDefinition = "DATETIME")
	LocalDateTime createdAt;
	
	@Column(name = "updatedAt", columnDefinition = "DATETIME")
	LocalDateTime updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(Double finalAmount) {
		this.finalAmount = finalAmount;
	}

	public Double getAdvanceAmount() {
		return advanceAmount;
	}

	public void setAdvanceAmount(Double advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	public Double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BookingRequest getBookingRequest() {
		return bookingRequest;
	}

	public void setBookingRequest(BookingRequest bookingRequest) {
		this.bookingRequest = bookingRequest;
	}

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

	@Override
	public String toString() {
		return "ConfirmBooking [id=" + id + ", finalAmount=" + finalAmount + ", advanceAmount=" + advanceAmount
				+ ", balanceAmount=" + balanceAmount + ", status=" + status + ", bookingRequest=" + bookingRequest
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	

}
