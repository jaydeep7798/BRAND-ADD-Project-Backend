package com.brand.serviceImpl;

import org.springframework.stereotype.Service;

import com.brand.model.LoginModel;
import com.brand.model.response.LoginResponse;
import com.brand.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
    private final String validEmail = "jaydeep@gmail.com";
    private final String validPassword = "123456";

	@Override
	public LoginResponse login(LoginModel request) {
		// TODO Auto-generated method stub
		  // Validate email and password
		LoginResponse response = new LoginResponse();
        if (validEmail.equals(request.getEmail()) && validPassword.equals(request.getPassword())) {
            response.setSuccess(true);
            response.setMessage("Login successful");
        } else {
            response.setSuccess(false);
            response.setMessage("Invalid email or password");
        }

        return response;
	}

}
