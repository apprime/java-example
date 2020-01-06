package com.javaexample.box;

import com.javaexample.colours.Colour;

import java.math.BigDecimal;

public class Box {

    private BigDecimal cost;
    private String name;
    private long weight;
    private Colour colour;
    private String country;

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public long getWeight() {
        return weight;
    }

    public Colour getColour() {
        return colour;
    }


    public void setWeight(long weight) {
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
