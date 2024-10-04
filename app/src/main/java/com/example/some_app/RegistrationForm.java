package com.example.some_app;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.some_app.modal.BeanSiteList;
import com.example.some_app.util.Utils;

//import org.apache.http.NameValuePair; // to ask
//import org.apache.http.message.BasicNameValuePair; // to ask

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;

public class RegistrationForm extends AppCompatActivity {

    private EditText inputFirstName, inputMiddleName, inputLastName, inputNumber, inputEmail;
    private Spinner spinnerCountry;
    private RadioGroup radioGroupWorking;
    private CheckBox checkboxEnglish, checkboxSpanish, checkboxFrench, checkboxGerman;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        // Initialize Views
        inputFirstName = findViewById(R.id.inputFirstName);
        inputMiddleName = findViewById(R.id.inputMiddleName);
        inputLastName = findViewById(R.id.inputLastName);
        inputNumber = findViewById(R.id.inputNumber);
        inputEmail = findViewById(R.id.inputEmail);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        radioGroupWorking = findViewById(R.id.radioGroupWorking);
        checkboxEnglish = findViewById(R.id.checkboxEnglish);
        checkboxSpanish = findViewById(R.id.checkboxSpanish);
        checkboxFrench = findViewById(R.id.checkboxFrench);
        checkboxGerman = findViewById(R.id.checkboxGerman);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Set Submit Button Click Listener
        btnSubmit.setOnClickListener(view -> submitForm());
    }

    private void submitForm() {

        // Get values from fields
        String firstName = inputFirstName.getText().toString();
        String middleName = inputMiddleName.getText().toString();
        String lastName = inputLastName.getText().toString();
        String number = inputNumber.getText().toString();
        String email = inputEmail.getText().toString();
        String country = spinnerCountry.getSelectedItem().toString();

        // Working status
        int selectedWorkingStatus = radioGroupWorking.getCheckedRadioButtonId();
        RadioButton radioButtonWorking = findViewById(selectedWorkingStatus);
        String workingStatus = radioButtonWorking.getText().toString();

        // Languages
        StringBuilder languages = new StringBuilder();
        if (checkboxEnglish.isChecked()) languages.append("English ");
        if (checkboxSpanish.isChecked()) languages.append("Spanish ");
        if (checkboxFrench.isChecked()) languages.append("French ");
        if (checkboxGerman.isChecked()) languages.append("German ");

        // Form validation and submission
        if (firstName.isEmpty() || lastName.isEmpty() || number.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Please fill in all required fields", Toast.LENGTH_LONG).show();
        } else if (!email.contains("@")) {
            Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_LONG).show();
        } else {
            // Here you can add logic to save the data
            Toast.makeText(this, "Registration Successful!", Toast.LENGTH_LONG).show();
        }
    }

}