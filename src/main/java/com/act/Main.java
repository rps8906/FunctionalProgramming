package com.act;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Optional<String> nombre = Optional.ofNullable(null);
        System.out.println(nombre.orElse("No hay nombre"));
    }

}