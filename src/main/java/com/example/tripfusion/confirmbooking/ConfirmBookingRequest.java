package com.example.tripfusion.confirmbooking;

public class ConfirmBookingRequest {
	
	Long id;
	
	Double finalAmount;
	
	Double advanceAmount;
	
	Double balanceAmount;
	
	String status;
	
	Long bookingRequestId;

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

	public Long getBookingRequestId() {
		return bookingRequestId;
	}

	public void setBookingRequestId(Long bookingRequestId) {
		this.bookingRequestId = bookingRequestId;
	}

	@Override
	public String toString() {
		return "ConfirmBookingRequest [id=" + id + ", finalAmount=" + finalAmount + ", advanceAmount=" + advanceAmount
				+ ", balanceAmount=" + balanceAmount + ", status=" + status + ", bookingRequestId=" + bookingRequestId
				+ "]";
	}
	
	

}
