package com.ryggsekk.promosoffers.dao;

import com.ryggsekk.promosoffers.model.Offer;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("offerDao")
public class OfferDaoImpl extends AbstractDao<Integer, Offer> implements OfferDao {

    public Offer findById(int id) {
        return getByKey(id);
    }

    public List<Offer> listOffers() {
        Criteria crit = createEntityCriteria();
        return (List<Offer>) crit.list();
    }

    public List<Offer> findByName(String name) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("name", name));
        return (List<Offer>) crit.list();
    }

    public List<Offer> findByCategory(String category) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("category", category));
        return (List<Offer>) crit.list();
    }

    public List<Offer> findByCategory(String category, Order order) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("category", category));
        crit.addOrder(order);
        return (List<Offer>) crit.list();
    }

    public void addOffer(Offer offer) {
        persist(offer);
    }

    public void updateOffer(Offer offer) {
        update(offer);
    }

    public void deleteOffer(Offer entity) {
        delete(entity);
    }
}
