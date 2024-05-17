package com.example.project1662.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1662.Adapter.BanglowAdapter;
import com.example.project1662.Domain.PropertyDomain;
import com.example.project1662.R;
import com.example.project1662.databinding.ActivityBanglowBinding;

import java.util.ArrayList;

public class Banglow extends AppCompatActivity {

    ImageView home, Contact, Fav, chat, profile;
    ActivityBanglowBinding binding;

    private RecyclerView.Adapter adapterBanglow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banglow);
        binding = ActivityBanglowBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        home= findViewById(R.id.imageView61);
        Contact=findViewById(R.id.imageView62);
        Fav=findViewById(R.id.imageView63);
        chat=findViewById(R.id.imageView64);
        profile=findViewById(R.id.imageView6);

        home.setOnClickListener(view -> startActivity(new Intent(Banglow.this,MainActivity.class)));
        Contact.setOnClickListener(view -> startActivity(new Intent(Banglow.this,Contact.class)));
        Fav.setOnClickListener(view -> startActivity(new Intent(Banglow.this,favourite.class)));
        chat.setOnClickListener(view -> startActivity(new Intent(Banglow.this,Chat.class)));
        profile.setOnClickListener(view -> startActivity(new Intent(Banglow.this, UserProfile.class)));

        initRecyclerView();
        initLocation();

    }

    private void initRecyclerView() {
        ArrayList<PropertyDomain> items = new ArrayList<>();
        items.add(new PropertyDomain("Apartment", "Royal Apartment", "LosAngles LA", "h_1", 1500, 2, 3));
        items.add(new PropertyDomain("House", "House with Great View", "Newyork NY", "h_2", 800, 1, 2));
        items.add(new PropertyDomain("Villa", "Royal Villa", "LosAngles La", "h_3", 999, 2, 1));

        binding.recommendedView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterBanglow = new BanglowAdapter(items);
        binding.recommendedView.setAdapter(adapterBanglow);
    }
    private void initLocation () {
        String[] items = new String[]{"LosAngles, USA", "NewYork, USA"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.locationSpin.setAdapter(adapter);
    }
}

