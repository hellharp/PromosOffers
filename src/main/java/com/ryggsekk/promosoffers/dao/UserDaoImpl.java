package com.ryggsekk.promosoffers.dao;
 
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import com.ryggsekk.promosoffers.model.User;
import java.util.List;
 
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
 
    
    public void save(User user) {
        persist(user);
    }
    
    public User findById(int id) {
        return getByKey(id);
    }
 
    public User findBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        return (User) crit.uniqueResult();
    }
 
    public List<User> listUsers() {
        Criteria crit = createEntityCriteria();
        return (List<User>) crit.list();
    }
     
}