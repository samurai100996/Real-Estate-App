
package com.example.project1662.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project1662.R;

public class LoginActivity extends AppCompatActivity {

    EditText edEmail, edPassword;
    TextView tv;
    ImageView image, admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edEmail = findViewById(R.id.editTextTextPersonName);
        edPassword = findViewById(R.id.editTextTextPasswordName);
        image = findViewById(R.id.imageView2);
        tv = findViewById(R.id.textView2);
        admin = findViewById(R.id.imageView);

        image.setOnClickListener(view -> {
            String username = edEmail.getText().toString();
            String password = edPassword.getText().toString();
            Database db=new Database(getApplicationContext(),"project1662",null,1);
            if(username.length()==0 || password.length()==0) {
                Toast.makeText(getApplicationContext(), "Please fill All Details", Toast.LENGTH_SHORT).show();
            }else{
                if(db.login(username,password)==1){
                    Toast.makeText(getApplicationContext(),"LOGIN SUCCESS",Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    // to save all the data with values
                    editor.apply();
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                }else{
                    Toast.makeText(getApplicationContext(),"Invalid Username and Password",Toast.LENGTH_SHORT).show();
                }

            }
        });
        admin.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this,AdminLoginActivity.class)));
        tv.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this,SignUpActivity.class)));
    }
}