package com.altimetrik.profile.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.profile.entity.Profile;
import com.altimetrik.profile.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {


    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
    
	@Autowired
	ProfileService profileService;
	
	//UC-2.1 end point to get all records of employees
	@GetMapping("/allEmployees")
	public Iterable<Profile> getAllEmployeeProfile() {
		logger.info("inside getAllEmployeeProfile controller");
		return profileService.getAllProfile();
	}
	
	//UC-2.2 end point to get record of employee by id
	@GetMapping("/employee/{id}")
	public Profile getEmployeeProfile(@PathVariable(value = "id") Long id) {
		logger.info("inside getEmployeeProfile controller for Id - " + id);
		return profileService.getById(id);
	}
	
	//UC-1 end point to save employee profile
	@PostMapping("/saveEmployee")
	public Profile saveEmployeeProfile(Profile profile) {
		logger.info("inside saveEmployeeProfile controller for employee name - " + profile.getName());
		return profileService.saveProfile(profile);
	}
	
}
