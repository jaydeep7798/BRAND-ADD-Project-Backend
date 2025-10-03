package com.brand.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brand.entity.*;
@Repository
public interface SignUpRepository  extends JpaRepository<SignUpEntity, Long>{
	SignUpEntity findByemail(String email);
}
