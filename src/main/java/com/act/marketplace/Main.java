package com.act.marketplace;

import com.act.marketplace.model.Product;
import com.act.marketplace.service.IKartService;
import com.act.marketplace.service.impl.KartServiceImpl;
import com.act.marketplace.utils.Etype;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        IKartService kartService = new KartServiceImpl();

        List<Product> products = setProducts();

        //Leemos los productos en nuestro carrito
        kartService.viewKart().forEach(System.out::println);

        //Agregamos productos a nuestro carrito
        kartService.addToKart(products.stream().filter(
                product -> product.getName().equals("Platano")).findFirst().orElseThrow(), 3000f);
        kartService.addToKart(products.stream().filter(
                product -> product.getName().equals("Naranja")).findFirst().orElseThrow(), 1200f);
        kartService.addToKart(products.stream().filter(
                product -> product.getName().equals("Tomate")).findFirst().orElseThrow(), 2000f);
        kartService.addToKart(products.stream().filter(
                product -> product.getName().equals("Papa")).findFirst().orElseThrow(), 2000f);
        kartService.addToKart(products.stream().filter(
                product -> product.getName().equals("TV Samsung 55 in")).findFirst().orElseThrow(), 1f);

        //Leemos los productos en nuestro carrito
        kartService.viewKart().forEach(System.out::println);
        System.out.println("El total a pagar es: $" + kartService.getTotalPrice() + " MXN");

        //Eliminamos productos de nuestro carrito
        kartService.removeFromKart(14, 1f);

        kartService.addToKart(products.stream().filter(
                product -> product.getName().equals("PlayStation 5")).findFirst().orElseThrow(), 1f);
        //Leemos los productos en nuestro carrito
        kartService.viewKart().forEach(System.out::println);
        System.out.println("El total a pagar es: $" + kartService.getTotalPrice() + " MXN");
    }

    private static List<Product> setProducts() {
        return List.of(
                new Product(1, "Platano", 10f, Etype.FRUTA),
                new Product(2, "Manzana", 25.5f, Etype.FRUTA),
                new Product(3, "Naranja", 12.5f, Etype.FRUTA),
                new Product(4, "Melon", 35f, Etype.FRUTA),
                new Product(5, "Sandia", 60f, Etype.FRUTA),
                new Product(6, "Zanahoria", 18f, Etype.VERDURA),
                new Product(7, "Brócoli", 31f, Etype.VERDURA),
                new Product(8, "Cebolla", 12f, Etype.VERDURA),
                new Product(9, "Papa", 20f, Etype.VERDURA),
                new Product(10, "Tomate", 23f, Etype.VERDURA),
                new Product(11, "Xbos Series S", 8000f, Etype.ELECTRONICO),
                new Product(12, "PlayStation 5", 9000f, Etype.ELECTRONICO),
                new Product(13, "Nintendo Switch", 6000f, Etype.ELECTRONICO),
                new Product(14, "TV Samsung 55 in", 4999f, Etype.ELECTRONICO),
                new Product(15, "Alexa Echo Show 2", 2500f, Etype.ELECTRONICO));
    }
}
