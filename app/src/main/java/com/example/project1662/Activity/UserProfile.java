package com.example.project1662.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project1662.R;

public class UserProfile extends AppCompatActivity {
    LinearLayout sell;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        sell=findViewById(R.id.imageView345);
        img=findViewById(R.id.imageView);

        sell.setOnClickListener(view -> startActivity(new Intent(UserProfile.this, Sell.class)));


        img.setOnClickListener(view -> startActivity(new Intent(UserProfile.this, AdminPanel.class)));
    }
}