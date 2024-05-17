package com.example.project1662.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project1662.Domain.PropertyDomain;
import com.example.project1662.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Sell extends AppCompatActivity {
    EditText titleEditText, addressEditText, descriptionEditText, priceEditText;
    Spinner typeSpinner, bedSpinner, bathSpinner;
    Button addButton;
    ArrayList<PropertyDomain> propertiesList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        // Initialize form fields
        titleEditText = findViewById(R.id.title_edit_text);
        addressEditText = findViewById(R.id.location_edit_text);
        descriptionEditText = findViewById(R.id.description_edit_text);
        priceEditText = findViewById(R.id.price_edit_text);
        typeSpinner = findViewById(R.id.property_type_spinner);
        bedSpinner = findViewById(R.id.bed_spinner);
        bathSpinner = findViewById(R.id.bath_spinner);
        addButton = findViewById(R.id.add_property_button);
        populateSpinner(typeSpinner, R.array.property_type_array);
        populateSpinner(bedSpinner, R.array.bed_array);
        populateSpinner(bathSpinner, R.array.bath_array);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProperty();
            }
        });
    }
    private void populateSpinner(Spinner spinner, int arrayResource) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                arrayResource, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    private void addProperty() {
        // Get data from form fields
        String title = titleEditText.getText().toString();
        String propertyType = typeSpinner.getSelectedItem().toString();
        String address = addressEditText.getText().toString();
        String description = descriptionEditText.getText().toString();
        int price = Integer.parseInt(priceEditText.getText().toString());
        int bed = Integer.parseInt(bedSpinner.getSelectedItem().toString());
        int bath = Integer.parseInt(bathSpinner.getSelectedItem().toString());
        boolean isWifi = false;
        // Create PropertyDomain object
        PropertyDomain property = new PropertyDomain(propertyType, title, address, description, price, bed, bath);

        // Load existing properties list from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("propertiesList", null);
        Type type = new TypeToken<ArrayList<PropertyDomain>>(){}.getType();
        ArrayList<PropertyDomain> existingList = gson.fromJson(json, type);

        // Append the new property to the existing list
        if (existingList == null) {
            existingList = new ArrayList<>();
        }
        existingList.add(property);

        // Save the updated list back to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String updatedJson = gson.toJson(existingList);
        editor.putString("propertiesList", updatedJson);
        editor.apply();

        // Notify the user that the property has been added
        Toast.makeText(Sell.this, "Property added successfully", Toast.LENGTH_SHORT).show();
    }
        /*// Assuming there's no control for this in the form

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("propertiesList", null);
        Type type = new TypeToken<ArrayList<PropertyDomain>>(){}.getType();
        ArrayList<PropertyDomain> existingList = gson.fromJson(json, type);

        // Append the new property to the existing list
        if (existingList == null) {
            existingList = new ArrayList<>();
        }


        // Save the updated list back to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String updatedJson = gson.toJson(existingList);
        editor.putString("propertiesList", updatedJson);
        editor.apply();

        // Create PropertyDomain object
        PropertyDomain property = new PropertyDomain(propertyType, title, address, description, price, bed, bath);
        propertiesList.add(property);
        existingList.add(property);
        savePropertiesList();
        clearFormFields();

        // Show a toast message
        Toast.makeText(Sell.this, "Property added successfully", Toast.LENGTH_SHORT).show();
    }
*/
    private void clearFormFields() {
        titleEditText.setText("");
        addressEditText.setText("");
        descriptionEditText.setText("");
        priceEditText.setText("");
        typeSpinner.setSelection(0);
        bedSpinner.setSelection(0);
        bathSpinner.setSelection(0);
    }

    private void savePropertiesList() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(propertiesList);
        editor.putString("propertiesList", json);
        editor.apply();
    }
}