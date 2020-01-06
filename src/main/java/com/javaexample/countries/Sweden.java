package com.javaexample.countries;

import java.math.BigDecimal;

public class Sweden extends Country {

    private BigDecimal shipmentModifier = new BigDecimal(1.3);

    @Override
    public String getName() {
        return "Sweden";
    }

    @Override
    public BigDecimal getShipmentModifier() {
        return shipmentModifier;
    }
}
