package com.example.project1662.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project1662.R;

public class AdminPanel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_panel);

        // Initialize your views
        TextView adminGreetingTextView = findViewById(R.id.adminGreetingTextView);
        LinearLayout newListingsButton = findViewById(R.id.newListingsButton);
        LinearLayout yourPropertiesButton = findViewById(R.id.yourPropertiesButton);
        LinearLayout messagesButton = findViewById(R.id.messagesButton);
        TextView backTextView = findViewById(R.id.backTextView);

        // Add your further logic here...
        newListingsButton.setOnClickListener(view -> startActivity(new Intent(AdminPanel.this, AddProperty.class)));

    }
}


