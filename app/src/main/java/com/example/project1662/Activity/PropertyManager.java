package com.example.project1662.Activity;

import com.example.project1662.Domain.PropertyDomain;

import java.util.ArrayList;

public class PropertyManager {
    private static ArrayList<PropertyDomain> properties = new ArrayList<>();

    public static void addProperty(PropertyDomain property) {
        properties.add(property);
    }

    public static ArrayList<PropertyDomain> getProperties() {
        return properties;
    }
}
