package com.example.some_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        Button buttonToCalculator = findViewById(R.id.buttonToCalculator);
        Button buttonToRegistrationForm = findViewById(R.id.regisForm);
        Button btnSchSites = findViewById(R.id.btnGetSchSites);

        // Set click listener for the calculator button
        buttonToCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to MainActivity2
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        // Set click listener for the registration form button
        buttonToRegistrationForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to RegistrationForm
                Intent intent2 = new Intent(MainActivity.this, RegistrationForm.class);
                startActivity(intent2);
            }
        });

        // click listener to get schedule sites
        btnSchSites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to RegistrationForm
                Intent intent3 = new Intent(MainActivity.this, DisplaySite.class);
                startActivity(intent3);
            }
        });
    }
}