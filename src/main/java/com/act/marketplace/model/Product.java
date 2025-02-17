package com.act.marketplace.model;

import com.act.marketplace.utils.Etype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Integer code;
    private String name;
    private Float price;
    private Etype departamento;
}
