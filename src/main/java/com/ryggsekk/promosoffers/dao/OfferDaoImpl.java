package com.ryggsekk.promosoffers.dao;

import com.ryggsekk.promosoffers.model.Offer;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("offerDao")
public class OfferDaoImpl extends AbstractDao<Integer, Offer> implements OfferDao {

    public List<Offer> getByCategory(String category) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("category", category));
        return (List<Offer>) crit.list();
    }

    public List<Offer> getByCategory(String category, Order order) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("category", category));
        crit.addOrder(order);
        return (List<Offer>) crit.list();
    }
}
