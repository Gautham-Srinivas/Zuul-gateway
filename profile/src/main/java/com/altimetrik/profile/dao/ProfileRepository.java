package com.altimetrik.profile.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altimetrik.profile.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
