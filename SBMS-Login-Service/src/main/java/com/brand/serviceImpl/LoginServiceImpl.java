package com.brand.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brand.client.SignUpClient;
import com.brand.common.dto.SignUpResponse;
import com.brand.model.LoginModel;
import com.brand.model.response.LoginResponse;
import com.brand.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
    @Autowired
    private SignUpClient signUpClient;

	@Override
	public LoginResponse login(LoginModel request) {
		  // TODO Auto-generated method stub
		LoginResponse response = new LoginResponse();
		SignUpResponse signUpResponse = signUpClient.getUserByEmail(request.getEmail());
        if (signUpResponse.getEmail().equals(request.getEmail()) && signUpResponse.getPassword().equals(request.getPassword())) {
            response.setSuccess(true);
            response.setMessage("Login successful");
        } else {
            response.setSuccess(false);
            response.setMessage("Invalid email or password");
        }
        return response;
	}
}
