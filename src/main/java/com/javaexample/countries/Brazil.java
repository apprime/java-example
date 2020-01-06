package com.javaexample.countries;

import java.math.BigDecimal;

public class Brazil extends Country {

    private BigDecimal shipmentModifier =  new BigDecimal(8.6);

    @Override
    public String getName() {
        return "Brazil";
    }

    @Override
    public BigDecimal getShipmentModifier() {
        return shipmentModifier;
    }
}
