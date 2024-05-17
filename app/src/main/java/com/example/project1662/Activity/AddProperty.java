package com.example.project1662.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project1662.Domain.PropertyDomain;
import com.example.project1662.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddProperty extends AppCompatActivity {
    ListView propertyListView;
    PropertyAdapter adapter;
    ArrayList<PropertyDomain> propertiesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_property);

        propertyListView = findViewById(R.id.property_list_view);
        loadProperties();
        adapter = new PropertyAdapter(this, propertiesList);
        propertyListView.setAdapter(adapter);
    }

    private void loadProperties() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("propertiesList", null);
        Type type = new TypeToken<ArrayList<PropertyDomain>>() {
        }.getType();
        propertiesList = gson.fromJson(json, type);

        if (propertiesList == null) {
            propertiesList = new ArrayList<>(); // Create new list if no data found
        }
    }

   /* @Override
    protected void onStop() {
        super.onStop();

        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }*/
}


