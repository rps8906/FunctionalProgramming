package com.act.marketplace.service;

import com.act.marketplace.model.Kart;
import com.act.marketplace.model.Product;

import java.util.List;

public interface IKartService {

    List<Kart>  viewKart ();
    void addToKart (Product product, Float amount);
    void removeFromKart(Integer idProduct, Float amount);
    Float getTotalPrice ();
}
