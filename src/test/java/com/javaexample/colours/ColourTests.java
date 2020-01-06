package com.javaexample.colours;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ColourTests {

    @Test public void parseColorFromString()
    {
        //Red 255, Green 0, Blue 14
        String testString = "FF0009";

        Colour result = Colour.parse(testString);

        Assertions.assertTrue(result.getRed() == 255);
        Assertions.assertTrue(result.getGreen() == 0);
        Assertions.assertTrue(result.getBlue() == 9);
    }

    @Test public void parseColorNullInput() {
        String testString = null;
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Colour.parse(testString));
    }

    @Test public void parseColorEdgeInput() {
        String testStringTooShort = "FF02";
        String testStringTooLong = "FF02";

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Colour.parse(testStringTooShort));

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Colour.parse(testStringTooLong));
    }
}
