package com.act.marketplace.service.impl;

import com.act.marketplace.function.ICalculateMinus;
import com.act.marketplace.function.ICalculatorSum;
import com.act.marketplace.model.Kart;
import com.act.marketplace.model.Product;
import com.act.marketplace.service.IKartService;
import com.act.marketplace.utils.Etype;

import java.util.ArrayList;
import java.util.List;

public class KartServiceImpl implements IKartService{

    private List<Kart> kart = new ArrayList<>();

    @Override
    public List<Kart> viewKart() {
        System.out.println("Nuestros productos en el carrito son los siguientes: ");
        return this.kart;
    }

    @Override
    public void addToKart(Product product, Float amount) {
        Kart karProduct = new Kart( product, amount);
        kart.add(karProduct);
        System.out.println("Producto "+ product.getName()+ " agregado al carrito" );

    }

    @Override
    public void removeFromKart(Integer idProduct, Float amount) {
        kart.stream().filter(productInKart -> productInKart.getProduct().getCode().equals(idProduct))
                .findFirst().ifPresent(productInKart -> {
                    ICalculateMinus restaProducto = monto -> productInKart.getAmount() - monto;
                    if(restaProducto.calculateTotal(amount) > 0) {
                        productInKart.setAmount(restaProducto.calculateTotal(amount));
                    } else {
                        kart.remove(productInKart);
                    }
        });
        System.out.println("Producto actualizado al resta del carrito");
    }

    @Override
    public Float getTotalPrice() {
        return kart.stream().map(productInKart -> {
            if(Etype.FRUTA.equals(productInKart.getProduct().getDepartamento()) || Etype.VERDURA.equals(productInKart.getProduct().getDepartamento())){
                ICalculatorSum productByWeight = (price, weight) -> (weight * price) /1000;
                return productByWeight.calculateTotal(productInKart.getProduct().getPrice(), productInKart.getAmount());
            } else {
                ICalculatorSum productByAmount = (price, amount) -> price * amount;
                return productByAmount.calculateTotal(productInKart.getProduct().getPrice(),
                        productInKart.getAmount());
            }
        }).reduce(Float::sum).orElse(0f);
    }
}