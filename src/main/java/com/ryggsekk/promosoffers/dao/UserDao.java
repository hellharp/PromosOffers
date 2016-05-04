package com.ryggsekk.promosoffers.dao;
 
import com.ryggsekk.promosoffers.model.User;
import java.util.List;
 
public interface UserDao {
    
    void save(User user);
 
    User findById(int id);
     
    User findBySSO(String sso);
    
    List<User> listUsers();
     
}