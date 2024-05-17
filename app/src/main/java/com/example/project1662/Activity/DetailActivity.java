package com.example.project1662.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project1662.Domain.PropertyDomain;
import com.example.project1662.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

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
    }
}