package com.javaexample.box;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.math.MathContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BoxCostCalculatorTests {

    @Test public void calculateBoxCost() {
        Box testBox = new Box();
        testBox.setCountry("Australia"); //7.2 modifier
        testBox.setWeight(1);
        BigDecimal correctValue = new BigDecimal(7.20000);

        testBox.setCost(BoxCostCalculator.Calculate(testBox));

        Assertions.assertTrue(testBox.getCost().compareTo(correctValue) == 0);
    }
}
