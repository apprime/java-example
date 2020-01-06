package com.javaexample.countries;

public class CountryFactory {
    public static Country Get(String countryName){
        if(countryName == null){
            throw new IllegalArgumentException("Country name cannot be null.");
        }

        switch (countryName)
        {
            case "Sweden": return new Sweden();
            case "Australia": return new Australia();
            case "China": return new China();
            case "Brazil": return new Brazil();
            default: throw new IllegalArgumentException(String.format("Country name cannot be found: %s", countryName));
        }
    }
}
