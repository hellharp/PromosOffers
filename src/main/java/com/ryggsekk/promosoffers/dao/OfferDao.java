package com.ryggsekk.promosoffers.dao;

import com.ryggsekk.promosoffers.model.Offer;
import org.hibernate.criterion.Order;

import java.util.List;

public interface OfferDao {

    List<Offer> getByCategory(String category);

    List<Offer> getByCategory(String category, Order order);


}
