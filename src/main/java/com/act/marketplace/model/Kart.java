package com.act.marketplace.model;

import com.act.marketplace.function.ICalculatorSum;
import com.act.marketplace.utils.Etype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kart {

    private Product product;
    private Float amount;

    @Override
    public String toString() {
        String amountDesc = "";
        Float unit = this.amount;
        ICalculatorSum calculateTotal = (price, weight) -> (weight * price);
        if (Etype.FRUTA.equals(product.getDepartamento()) || Etype.VERDURA.equals(product.getDepartamento())){
            unit = this.amount/1000;
            amountDesc = "KG";
            calculateTotal = (price, weight) -> (weight * price) /1000;
        }
        return String.join(", ", new String ("Cantidad: "+ unit.toString() + " " +amountDesc).trim(), "Producto: '" + this.product.getName()+ "'",  "Precio Unitario: $" + this.product.getPrice().toString(), "Total: $" + calculateTotal.calculateTotal(this.product.getPrice(), this.amount));
    }
}
