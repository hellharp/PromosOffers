package com.ryggsekk.promosoffers.dao;

import com.ryggsekk.promosoffers.model.Offer;
import org.hibernate.criterion.Order;

import java.util.List;

public interface OfferDao {

    Offer findById(int id);

    List<Offer> listOffers();

    List<Offer> findByName(String name);

    List<Offer> findByCategory(String category);

    List<Offer> findByCategory(String category, Order order);

    void addOffer(Offer offer);

    void updateOffer(Offer offer);

    void deleteOffer(Offer offer);
}
