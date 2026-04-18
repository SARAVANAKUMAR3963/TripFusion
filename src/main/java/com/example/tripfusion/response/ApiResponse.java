package com.example.tripfusion.response;


public class ApiResponse {
    int statusCode;
    String statusText;
    Object responseData;
    String message;

    public ApiResponse() {
        this.statusCode = 200;
        this.statusText = "";
        this.responseData = null;
    }

    public ApiResponse(int statusCode, String statusText, Object responseData) {
        this.statusCode = statusCode;
        this.statusText = statusText;
        this.responseData = responseData;
    }
    
    public ApiResponse(int statusCode, String statusText,String message, Object responseData ) {
        this.statusCode = statusCode;
        this.statusText = statusText;
        this.responseData = responseData;
        this.message=message;
    }

    
    
    
    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Object getResponseData() {
        return responseData;
    }

    public void setResponseData(Object responseData) {
        this.responseData = responseData;
    }

    @Override
    public String toString() {
        return "ApiResponse [statusCode=" + statusCode + ", statusText=" + statusText + ", responseData=" + responseData
                + "]";
    }


}
