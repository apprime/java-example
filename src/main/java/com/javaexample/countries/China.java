package com.javaexample.countries;

import java.math.BigDecimal;

public class China extends Country {

    private BigDecimal shipmentModifier = new BigDecimal(4);

    @Override
    public String getName() {
        return "China";
    }

    @Override
    public BigDecimal getShipmentModifier() {
        return shipmentModifier;
    }
}
