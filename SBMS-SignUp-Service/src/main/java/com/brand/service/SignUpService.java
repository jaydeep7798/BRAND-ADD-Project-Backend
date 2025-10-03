package com.brand.service;

import com.brand.model.SignUpModel;
import com.brand.common.dto.*;

public interface SignUpService {
  public SignUpResponse signup(SignUpModel signUpModel);
}
