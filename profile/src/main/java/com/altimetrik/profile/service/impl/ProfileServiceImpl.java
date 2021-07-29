package com.altimetrik.profile.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.profile.dao.ProfileRepository;
import com.altimetrik.profile.entity.Profile;
import com.altimetrik.profile.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{

    private static final Logger logger = LoggerFactory.getLogger(ProfileService.class);

	@Autowired
	ProfileRepository repository;
	
	public Iterable<Profile> getAllProfile(){
		logger.info("inside getAllprofile");
		return repository.findAll();
	}
	
	public Profile getById(Long id){
		logger.info("inside getById");
		Optional<Profile> result = repository.findById(id);
		return result.get();
	}
	
	public Profile saveProfile(Profile profile){
		logger.info("inside saveProfile");
		Profile result = repository.save(profile);
		return result;
	}

}
