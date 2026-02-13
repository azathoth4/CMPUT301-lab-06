package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<Object>{
    private String city;
    private String province;

    /**
     * Constructor for City
     * @param city The name of the city
     * @param province The name of the province
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the city name
     * @return String representing the city name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * Gets the province name
     * @return String representing the province name
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Compares this city to another object based on city name
     * @param o te object to compare to
     * @return negative integer, zero, or a positive integer as this city
     * is less than, equal to, or greater than the specified object
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

    /**
     * Checks equality based on both city and province names
     * Modified from https://www.infoworld.com/article/2256967/comparing-java-objects-with-equals-and-hashcode.html
     * @param o The object to compare
     * @return True if attributes match, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return city.equals(city1.city) && province.equals(city1.province);
    }

    /**
     * Generates a hash code for the city object
     * Modified from https://www.infoworld.com/article/2256967/comparing-java-objects-with-equals-and-hashcode.html
     * @return int hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }

}