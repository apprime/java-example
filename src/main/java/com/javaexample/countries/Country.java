package com.javaexample.countries;

import java.math.BigDecimal;

public abstract class Country {

    private int id;
    protected String name;

    public int getId() {
        return id;
    }

    public abstract String getName();

    public abstract BigDecimal getShipmentModifier();

    public void setId(int id) {
        this.id = id;
    }
}
