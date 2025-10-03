package com.brand.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brand.dao.SignUpRepository;
import com.brand.entity.SignUpEntity;
import com.brand.model.SignUpModel;
import com.brand.common.dto.*;
import com.brand.service.SignUpService;

@Service
public class SignUpServiceImpl implements SignUpService {
    
	@Autowired
	private SignUpRepository signUpRepository;
	@Override
	public SignUpResponse signup(SignUpModel signUpModel) {
		// TODO Auto-generated method stub
	      // Convert DTO -> Entity
		SignUpResponse response = new SignUpResponse();
		try {
			SignUpEntity entity = new SignUpEntity();
	        entity.setFullName(signUpModel.getFullName());
	        entity.setEmail(signUpModel.getEmail());
	        //entity.setPassword(signUpModel.getPassword());
	        entity.setPhone(signUpModel.getPhone());
	        entity.setCity(signUpModel.getCity());
	        entity.setTerms(signUpModel.isTerms());
	        entity.setPassword(signUpModel.getPassword());

	        // Save to DB
	        SignUpEntity savedEntity = signUpRepository.save(entity);

	        if(response != null) {
	        	response.setSuccess(true);
	            response.setUserId(savedEntity.getId().toString());
	            response.setEmail(savedEntity.getEmail());
	            response.setMessage("User registered successfully!");
	        }

	        return response;
			
		} catch(Exception e) {
			response.setSuccess(false);
            response.setMessage("User Not registered!");
		}
		return response;
	}
}
