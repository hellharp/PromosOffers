package com.ryggsekk.promosoffers.service;

import com.ryggsekk.promosoffers.model.Offer;
import org.hibernate.criterion.Order;

import java.util.List;

public interface OfferService {

    Offer findById(int id);

    List<Offer> findByName(String name);

    List<Offer> findByCategory(String category);

    List<Offer> findByCategory(String category, Order order);

}
