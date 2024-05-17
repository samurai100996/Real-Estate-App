package com.example.project1662.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1662.Adapter.NearbyAdapter;
import com.example.project1662.Adapter.RecommendedAdapter;
import com.example.project1662.Domain.PropertyDomain;
import com.example.project1662.R;
import com.example.project1662.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    ImageView img1, img2, img3, img4, pfp,home, Contact, Fav, chat, icon;
    private RecyclerView.Adapter adapterRecommended,adapterNearby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        img1 = findViewById(R.id.imageView51);
        img2 = findViewById(R.id.imageView52);
        img3 = findViewById(R.id.imageView53);
        img4 = findViewById(R.id.imageView5);
        pfp = findViewById(R.id.imageView6);
        home = findViewById(R.id.imageView61);
        Contact = findViewById(R.id.imageView62);
        Fav = findViewById(R.id.imageView63);
        chat = findViewById(R.id.imageView64);
        icon = findViewById(R.id.imageView2);

        img1.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,HouseActivity.class)));
        img2.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,AppartmentActivity.class)));
        img3.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,VillaActivity.class)));
        img4.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,Banglow.class)));
        pfp.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, UserProfile.class)));
        home.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, MainActivity.class)));
        Contact.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Contact.class)));
        Fav.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, favourite.class)));
        chat.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Chat.class)));
        icon.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, AdminPanel.class)));


        initLocation();
        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<PropertyDomain> items=new ArrayList<>();
        items.add(new PropertyDomain("Apartment","Royal Apartment","LosAngles LA","h_1",1500,2,3));
        items.add(new PropertyDomain("House","House with Great View","Newyork NY","h_2",800,1,2));
        items.add(new PropertyDomain("Villa","Royal Villa","LosAngles La","h_3",999,2,1));

        binding.recommendedView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterRecommended=new RecommendedAdapter(items);
        binding.recommendedView.setAdapter(adapterRecommended);

        binding.nearbyView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapterNearby=new NearbyAdapter(items);
        binding.nearbyView.setAdapter(adapterNearby);
    }

    private void initLocation() {
        String[] items=new String[]{"LosAngles, USA","NewYork, USA"};

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.locationSpin.setAdapter(adapter);
    }
}