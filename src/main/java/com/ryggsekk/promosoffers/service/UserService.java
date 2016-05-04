package com.ryggsekk.promosoffers.service;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
 
import com.ryggsekk.promosoffers.model.User;
import java.util.List;
 
public interface UserService {
 
    void save(User user);
    
    User findById(int id);
     
    User findBySso(String sso);
    
   
     
}