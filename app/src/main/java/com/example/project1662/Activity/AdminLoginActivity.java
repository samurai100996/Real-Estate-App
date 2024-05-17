package com.example.project1662.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project1662.R;

public class AdminLoginActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private ImageView buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login2);

        editTextUsername = findViewById(R.id.adminame);
        editTextPassword = findViewById(R.id.adminPassword);
        buttonLogin = findViewById(R.id.go);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        if (username.equals("admin") && password.equals("pass123$$")) {
            // Successful login, navigate to main activity
            Intent intent = new Intent(AdminLoginActivity.this, AdminPanel.class);
            startActivity(intent);
            finish();
        } else {
            // Login failed, show toast message
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }
}
