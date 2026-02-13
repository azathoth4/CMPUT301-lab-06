package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.countCities());
        assertTrue(cityList.hasCity(city));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City city = new City("Edmonton", "Alberta");
        assertTrue(cityList.hasCity(city));

        City cityNotPresent = new City("Vancouver", "BC");
        assertFalse(cityList.hasCity(cityNotPresent));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City city = new City("Edmonton", "Alberta");

        assertTrue(cityList.hasCity(city));
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City cityNotInList = new City("Calgary", "Alberta");

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(cityNotInList);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());
        cityList.add(mockCity());
        assertEquals(1, cityList.countCities());
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        // Charlottetown comes before Edmonton
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
}