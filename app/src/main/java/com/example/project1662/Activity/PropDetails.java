package com.example.project1662.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project1662.Domain.PropertyDomain;
import com.example.project1662.R;

public class PropDetails extends AppCompatActivity {

    private PropertyDomain selectedProperty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prop_details);

        selectedProperty = getPropertyData(); // Implement this method to get selected property

        Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pass selected property data to MainActivity
                Intent intent = new Intent(PropDetails.this, MainActivity.class);
                intent.putExtra("PROPERTY_DATA", selectedProperty);
                startActivity(intent);
            }
        });
    }

        // Implement this method to get the selected property data
        private PropertyDomain getPropertyData () {
            // Logic to get the selected property data from your ListView or any other source
            // Return the selected property object


            // Retrieve the property object passed from the previous activity
            Intent intent = getIntent();
            if (intent != null) {
                PropertyDomain property = (PropertyDomain) intent.getSerializableExtra("property");
                if (property != null) {
                    // Find views in the layout
                    ImageView picDetail = findViewById(R.id.picDetail);
                    TextView typeTxt = findViewById(R.id.typeTxt);
                    TextView titleTxt = findViewById(R.id.titleTxt);
                    TextView addressTxt = findViewById(R.id.addressTxt);
                    TextView bedTxt = findViewById(R.id.bedTxt);
                    TextView bathTxt = findViewById(R.id.bathTxt);
                    TextView wifiTxt = findViewById(R.id.wifiTxt);
                    TextView descriptionTxt = findViewById(R.id.descriptionTxt);

                    // Set property details to views
                    // You need to replace these with actual getters from PropertyDomain
                    // For example:
                    // picDetail.setImageResource(property.getPicPath());
                    typeTxt.setText(property.getType());
                    titleTxt.setText(property.getTitle());
                    addressTxt.setText(property.getAddress());
                    bedTxt.setText(property.getBed() + " Bed");
                    bathTxt.setText(property.getBath() + " Bath");
                    wifiTxt.setText(property.isRent() ? "Wifi Available" : "No Wifi");
                    descriptionTxt.setText(property.getDescription());
                }
            }

                // Logic to get the selected property data from your ListView or any other source
                // Return the selected property object
                return null; // Replace null with your actual implementation

            }


}