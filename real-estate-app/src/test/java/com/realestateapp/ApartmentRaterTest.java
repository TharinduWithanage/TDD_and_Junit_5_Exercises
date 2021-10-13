package com.realestateapp;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class ApartmentRaterTest {
    @Test
    void should_ReturnErrorValue_When_IncorrectApartment() {
        Apartment apartmentError = new Apartment(0, new BigDecimal(10000.0));
        assertEquals(-1, ApartmentRater.rateApartment(apartmentError));

    }
    @Test
    void should_ReturnCorrectRating_When_CorrectApartment() {
        Apartment apartmentBest = new Apartment(5.0, new BigDecimal(10000.0));
        assertEquals(0, ApartmentRater.rateApartment(apartmentBest));

        Apartment apartmentNormal = new Apartment(2.0, new BigDecimal(14000.0));
        assertEquals(1, ApartmentRater.rateApartment(apartmentNormal));

        Apartment apartmentWorst = new Apartment(2.0, new BigDecimal(20000.0));
        assertEquals(2, ApartmentRater.rateApartment(apartmentWorst));

    }
    @Test
    void should_CalculateAverageRating_When_CorrectApartmentList(){

        Apartment apartment1 = new Apartment(5.0, new BigDecimal(35000.0));
        Apartment apartment2 = new Apartment(2.0, new BigDecimal(14000.0));
        Apartment apartment3 = new Apartment(2.0, new BigDecimal(26000.0));
        Apartment apartment4 = new Apartment(2.0, new BigDecimal(25000.0));
        Apartment apartment5 = new Apartment(2.0, new BigDecimal(13000.0));
        Apartment apartment6 = new Apartment(2.0, new BigDecimal(30000.0));

        List<Apartment> apartments_list = new ArrayList<Apartment>();
        apartments_list.add(apartment1);
        apartments_list.add(apartment2);
        apartments_list.add(apartment3);
        apartments_list.add(apartment4);
        apartments_list.add(apartment5);
        apartments_list.add(apartment6);

        assertEquals(1.5, ApartmentRater.calculateAverageRating(apartments_list));

    }

//    @Test
//     void should_ThrowExceptionInCalculateAverageRating_When_EmptyApartmentList(){
//
//        List<Apartment> apartments_list = new ArrayList<Apartment>();
//
//        String expectedMessage = "Cannot calculate average rating for empty list";
//        String actualMessage = ApartmentRater.calculateAverageRating(apartments_list);
//
//        assertEquals(RuntimeException.class, ApartmentRater.calculateAverageRating(apartments_list));
//
//    }
}
