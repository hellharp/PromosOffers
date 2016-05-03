package com.ryggsekk.promosoffers.dao;
 
import java.util.List;
 
import com.ryggsekk.promosoffers.model.UserProfile;
 
public interface UserProfileDao {
 
    List<UserProfile> findAll();
     
    UserProfile findByType(String type);
     
    UserProfile findById(int id);
}