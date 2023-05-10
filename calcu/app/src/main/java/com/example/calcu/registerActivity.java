package com.example.calcu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity {
    EditText ID, email, name, password, confirmpass;
    Button create;
    TextView toLogin;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        ID = findViewById(R.id.et_idbimbel);
        email = findViewById(R.id.et_email);
        name = findViewById(R.id.et_name);
        password = findViewById(R.id.et_password);
        confirmpass = findViewById(R.id.et_confirmpassword);
        create = findViewById(R.id.bt_create);
        toLogin = findViewById(R.id.tv_tologin);

        toLogin.setOnClickListener(v -> {
            startActivity(new Intent(registerActivity.this, MainActivity.class));
        });

        sharedPref = getSharedPreferences("user_account", MODE_PRIVATE);

        create.setOnClickListener(v -> {
            if (ID.getText().toString().length() <= 3) {
                Toast.makeText(this, "ID must be longet than 3 digits", Toast.LENGTH_SHORT).show();
            } else if ((!email.getText().toString().contains("@") || !email.getText().toString().contains(".com") || email.getText().toString().indexOf("@") > email.getText().toString().indexOf(".com"))) {
                Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show();
            } else if (name.getText().toString().length() < 5) {
                Toast.makeText(this, "name must be at least 5 characters long", Toast.LENGTH_SHORT).show();
            } else if (password.getText().toString().length() < 3) {
                Toast.makeText(this, "password is too short", Toast.LENGTH_SHORT).show();
            } else if (!password.getText().toString().equals(confirmpass.getText().toString())) {
                Toast.makeText(this, "confirm your password", Toast.LENGTH_SHORT).show();
            } else {
                SharedPreferences.Editor edit = sharedPref.edit();
                edit.putString("email", email.getText().toString());
                edit.putString("password", password.getText().toString());
                edit.apply();
                startActivity(new Intent(registerActivity.this, MainActivity.class));
            }
        });








    }
}