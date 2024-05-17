package com.example.project1662.Activity;

public class Property {
    private String propertyType;
    private String title;
    private String location;
    private double price;
    private int bedrooms;
    private int bathrooms;

    public class PropertyDomain {
        private String propertyType;
        private String title;
        private String location;
        private double price;
        private int bedrooms;
        private int bathrooms;

    }

    public String getPropertyType() {
        return propertyType;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }
}
