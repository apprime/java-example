package com.javaexample.countries;

import java.math.BigDecimal;

public class Australia extends Country {

    private BigDecimal shipmentModifier =  new BigDecimal(7.2);

    @Override
    public String getName() {
        return "Australia";
    }

    @Override
    public BigDecimal getShipmentModifier() {
        return shipmentModifier;
    }
}
