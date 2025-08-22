package com.brand.service;

import com.brand.model.LoginModel;
import com.brand.model.response.LoginResponse;

public interface LoginService {
	public LoginResponse login(LoginModel request);
}
