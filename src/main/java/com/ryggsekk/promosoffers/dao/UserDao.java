package com.ryggsekk.promosoffers.dao;
 
import com.ryggsekk.promosoffers.model.User;
 
public interface UserDao {
 
    User findById(int id);
     
    User findBySSO(String sso);
     
}