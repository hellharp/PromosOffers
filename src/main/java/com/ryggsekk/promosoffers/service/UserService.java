package com.ryggsekk.promosoffers.service;
 
import com.ryggsekk.promosoffers.model.User;
 
public interface UserService {
 
    void save(User user);
    User findById(int id);
     
    User findBySso(String sso);
     
}