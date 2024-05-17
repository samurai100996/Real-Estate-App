package com.example.project1662.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1662.Adapter.FavouriteAdapter;
import com.example.project1662.Domain.PropertyDomain;
import com.example.project1662.R;
import com.example.project1662.databinding.ActivityFavouriteBinding;

import java.util.ArrayList;

public class favourite extends AppCompatActivity {
    ImageView home, Contact, Fav, chat, profile;
    ActivityFavouriteBinding binding;

    private RecyclerView.Adapter adapterFavourite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFavouriteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        home = findViewById(R.id.imageView61);
        Contact = findViewById(R.id.imageView62);
        Fav = findViewById(R.id.imageView63);
        chat = findViewById(R.id.imageView64);
        profile = findViewById(R.id.imageView6);

        home.setOnClickListener(view -> startActivity(new Intent(favourite.this, MainActivity.class)));
        Contact.setOnClickListener(view -> startActivity(new Intent(favourite.this, Contact.class)));
        Fav.setOnClickListener(view -> startActivity(new Intent(favourite.this, favourite.class)));
        chat.setOnClickListener(view -> startActivity(new Intent(favourite.this, Chat.class)));
        profile.setOnClickListener(view -> startActivity(new Intent(favourite.this, UserProfile.class)));

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<PropertyDomain> items = new ArrayList<>();
        items.add(new PropertyDomain("Apartment", "Royal Apartment", "LosAngles LA", "h_1", 1500, 2, 3));
        items.add(new PropertyDomain("House", "House with Great View", "Newyork NY", "h_2", 800, 1, 2));
        items.add(new PropertyDomain("Villa", "Royal Villa", "LosAngles La", "h_3", 999, 2, 1));
        items.add(new PropertyDomain("Apartment", "Royal Apartment", "LosAngles LA", "h_1", 1500, 2, 3));
        items.add(new PropertyDomain("House", "House with Great View", "Newyork NY", "h_2", 800, 1, 2));
        items.add(new PropertyDomain("Villa", "Royal Villa", "LosAngles La", "h_3", 999, 2, 1));

        binding.recommendedView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapterFavourite = new FavouriteAdapter(items);
        binding.recommendedView.setAdapter(adapterFavourite);
    }

}

