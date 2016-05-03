package com.ryggsekk.promosoffers.service;

import com.ryggsekk.promosoffers.dao.OfferDao;
import com.ryggsekk.promosoffers.model.Offer;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("offerService")
@Transactional
public class OfferServiceImpl implements OfferService{

    @Autowired
    private OfferDao dao;

    public Offer findById(int id) {
        return dao.findById(id);
    }

    public List<Offer> findByName(String name) {
        return dao.findByName(name);
    }

    public List<Offer> findByCategory(String category) {
        return dao.findByCategory(category);
    }

    public List<Offer> findByCategory(String category, Order order) {
        return dao.findByCategory(category, order);
    }
}