package com.act.marketplace.utils;

import lombok.Getter;

@Getter
public enum Etype {

    FRUTA("Fruta"),
    VERDURA("Verdura"),
    ELECTRONICO("Electronico"),
    LINEA_BLANCA("Linea Blanca"),
    HOGAR("Hogar"),
    LACTEOS("Lacteos");

    private final String departamento;

    Etype(String departamento) {
        this.departamento = departamento;
    }
}
