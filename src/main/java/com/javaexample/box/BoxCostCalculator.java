package com.javaexample.box;

import com.javaexample.countries.CountryFactory;
import com.javaexample.countries.Country;

import java.math.BigDecimal;

public class BoxCostCalculator {

    public static BigDecimal Calculate(Box box) throws IllegalArgumentException {
        Country boxCountry = CountryFactory.Get(box.getCountry());

        BigDecimal modifier = boxCountry.getShipmentModifier();
        BigDecimal base = new BigDecimal(box.getWeight());

        return base.multiply(modifier);
    }
}
