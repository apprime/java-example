package com.javaexample.colours;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Colour {
    @JsonProperty("r") private int red;
    @JsonProperty("g") private int green;
    @JsonProperty("b") private int blue;

    public Colour(){
    }

    public Colour(int red, int green, int blue){
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }

    public static Colour parse(String colour) throws IllegalArgumentException {

        if(colour == null || colour.length() != 6){
            throw new IllegalArgumentException("Can only parse string if 6 letters in hexadecimal format.");
        }

        int r = Integer.parseInt(colour.substring(0,2), 16);
        int g = Integer.parseInt(colour.substring(2,4), 16);
        int b = Integer.parseInt(colour.substring(4,6), 16);

        return new Colour(r,g,b);
    }

    public String toHex(){
        return String.format("%02X%02X%02X", red, green, blue);
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
}
