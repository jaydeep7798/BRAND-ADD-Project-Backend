package com.brand.common.dto;


public class SignUpResponse {

    private boolean success;
    private String userId;
    private String email;
    private String password;
	private String message;

    // Constructors
    public SignUpResponse() {
    }

    public SignUpResponse(boolean success, String userId, String email, String message,String password) {
        this.success = success;
        this.userId = userId;
        this.email = email;
        this.message = message;
        this.password =password;
    }

    // Getters and Setters
    public String getPassword() {
 		return password;
 	}

 	public void setPassword(String password) {
 		this.password = password;
 	}
 	
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // toString (useful for logging/debugging)
    @Override
    public String toString() {
        return "SignUpResponse{" +
                "success=" + success +
                ", userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
