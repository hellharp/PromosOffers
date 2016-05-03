package com.ryggsekk.promosoffers.service;

import java.util.List;
 
import com.ryggsekk.promosoffers.model.UserProfile;
 
public interface UserProfileService {
 
    List<UserProfile> findAll();
     
    UserProfile findByType(String type);
     
    UserProfile findById(int id);
}