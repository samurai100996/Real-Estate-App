package com.example.project1662.Activity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project1662.R;

public class SignUpActivity extends AppCompatActivity {

    EditText edusername, edemail, edpassword, edconfirm;
    ImageView btn;
    TextView tv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edusername = findViewById(R.id.editTextTextPersonName2);
        edemail = findViewById(R.id.editTextTextPersonName);
        edpassword = findViewById(R.id.editTextTextPasswordName1);
        edconfirm = findViewById(R.id.editTextTextPasswordName);
        btn = findViewById(R.id.imageView2);
        tv = findViewById(R.id.textView2);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edusername.getText().toString();
                String email = edemail.getText().toString();
                String password = edpassword.getText().toString();
                String confirm = edconfirm.getText().toString();
                Database db=new Database(getApplicationContext(),"project1662",null,1);
                if (username.length() == 0 || email.length() == 0 || password.length() == 0 || confirm.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill All the details", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password.compareTo(confirm) == 0){
                        if (isValid(password)) {
                            db.register(username, email, password);
                            Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "password must contain atleast 8 characters, having letters, digit and special charachter", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Privous password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
    }

    public static boolean isValid(String passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordhere.length() < 8) {
            return false;
        }
        else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                }
                for (int r = 0; r < passwordhere.length(); r++) {
                    if (Character.isDigit(passwordhere.charAt(r))) {
                        f2 = 1;
                    }
                }
                for (int s = 0; s < passwordhere.length(); s++) {
                    char c = passwordhere.charAt(s);
                    if (c >= 33 && c <= 46 || c == 64) {
                        f3 = 1;
                    }
                }
                if (f1 == 1 && f2 == 1 && f3 == 1)
                    return true;
                return false;
            }
        }
        return false;
    }
}