package com.realestateapp;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RandomApartmentGeneratorTest {
    @Test
    void should_GenerateCorrectApartment_When_DefaultMinAreaMinPrice() {

        RandomApartmentGenerator randomApartment = new RandomApartmentGenerator();
        Apartment apartment1 = randomApartment.generate();

        assertTrue(apartment1.getArea() >= 30 && apartment1.getArea() <= 120);
        assertTrue(apartment1.getPrice().doubleValue() >= apartment1.getArea() * 3000.0
                && apartment1.getPrice().doubleValue() <= apartment1.getArea() * 12000.0);

    }

    @Test
    void should_GenerateCorrectApartment_When_CustomMinAreaMinPrice() {

        RandomApartmentGenerator randomApartment =
                new RandomApartmentGenerator(40, new BigDecimal(4500.0));
        Apartment apartment1 = randomApartment.generate();

        assertTrue(apartment1.getArea() >= 40 && apartment1.getArea() <= 160);
        assertTrue(apartment1.getPrice().doubleValue() >= apartment1.getArea() * 4500.0
                && apartment1.getPrice().doubleValue() <= apartment1.getArea() * 18000.0);

    }

}
