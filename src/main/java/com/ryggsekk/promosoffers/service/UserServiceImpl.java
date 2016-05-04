package com.ryggsekk.promosoffers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ryggsekk.promosoffers.dao.UserDao;
import com.ryggsekk.promosoffers.model.User;

import java.util.HashSet;
import com.ryggsekk.promosoffers.model.UserProfile;
import java.util.List;
import java.util.Set;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getUserProfiles() == null || user.getUserProfiles().isEmpty())
        {
            UserProfile tmpuf = new UserProfile();
            tmpuf.setId(1);
            tmpuf.setType("USER");
            Set<UserProfile> uf = new HashSet<UserProfile>();
            uf.add(tmpuf);
            user.setUserProfiles(uf);
        }
        dao.save(user);
    }

    public User findById(int id) {
        return dao.findById(id);
    }

    public User findBySso(String sso) {
        return dao.findBySSO(sso);
    }

    public List<User> listUsers()
    {
        return dao.listUsers();
    }
}
