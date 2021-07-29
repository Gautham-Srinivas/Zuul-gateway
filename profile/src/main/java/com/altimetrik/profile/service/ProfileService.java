package com.altimetrik.profile.service;

import com.altimetrik.profile.entity.Profile;

public interface ProfileService {
	
	public Iterable<Profile> getAllProfile();
	
	public Profile getById(Long id);
	
	public Profile saveProfile(Profile profile);

}
