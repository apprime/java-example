package com.javaexample.countries;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CountryFactoryTests {

    @Test public void getCountryNullInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> CountryFactory.Get(null));
    }

    @Test public void getCountryFaultyInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  CountryFactory.Get("Denmark"));
    }

    @Test public void getCountry() {
       Country testCountry = CountryFactory.Get("China");

       Assertions.assertTrue(testCountry.getName() == "China");
    }
}
