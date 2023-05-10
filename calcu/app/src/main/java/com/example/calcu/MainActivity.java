package com.example.calcu;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView toRegis;
    Button login;
    EditText email, password;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.bt_login);
        toRegis = findViewById(R.id.tv_toregister);
        email = findViewById(R.id.et_emaillogin);
        password = findViewById(R.id.et_passwordlogin);

        toRegis.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, registerActivity.class));
        });


        sharedPref = getSharedPreferences("user_account", MODE_PRIVATE);
        login.setOnClickListener(v -> {
            if (email.getText().toString().length() < 5 || (!email.getText().toString().contains("@") || !email.getText().toString().contains(".com")) || email.getText().toString().indexOf("@") > email.getText().toString().indexOf(".com")) {
                Toast.makeText(this, "invalid email", Toast.LENGTH_SHORT).show();
            } else if(!email.getText().toString().equals(sharedPref.getString("email", ""))) {
                Toast.makeText(this, "email unregistered", Toast.LENGTH_SHORT).show();
            } else if(!password.getText().toString().equals(sharedPref.getString("password", ""))) {
                Toast.makeText(this, "wrong password", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(MainActivity.this, home.class));
            }
        });
    }
}