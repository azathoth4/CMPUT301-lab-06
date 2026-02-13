package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city this is a candidate city to add
     * @throws IllegalArgumentException if city already exists in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * Checks if a city is present in the list
     * @param city the city to search for
     * @return TRUE if the city exists in the list FALSE otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes a city from the list if it exists
     * @param city the city to be removed
     * @throws IllegalArgumentException if the city is not found in the list
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found in list");
        }
        cities.remove(city);
    }

    /**
     * Returns the number of cities currently in the list
     * @return int representing the count of cities
     */
    public int countCities() {
        return cities.size();
    }

    /**
     * This returns a sorted list of cities
     * @return return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }
}