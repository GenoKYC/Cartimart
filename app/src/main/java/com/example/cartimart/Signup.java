package com.example.cartimart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {

    TextView textSignin;
    private Accountdatabase dbHelper;

    CheckBox checkbox;

    Button signinbutton;
    EditText fullnameInput,emailaddressInput,passwordInput,confirmpasswordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        fullnameInput = findViewById(R.id.fullnameInput);
        emailaddressInput = findViewById(R.id.emailaddressInput);
        passwordInput = findViewById(R.id.passwordInput);
        confirmpasswordInput = findViewById(R.id.confirmpasswordInput);
        signinbutton = findViewById(R.id.signinbutton);
        dbHelper = new Accountdatabase(this);
        checkbox = findViewById(R.id.checkBox);
        textSignin = findViewById(R.id.textSignin);
        textSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signup.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        signinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkForMissingFields();
            }

            private void checkForMissingFields() {

                boolean missingFields = false;
                if (fullnameInput.getText().toString().isEmpty()) {
                    fullnameInput.setError("This field is required");
                    missingFields = true;
                }

                if (emailaddressInput.getText().toString().isEmpty()) {
                    emailaddressInput.setError("This field is required");
                    missingFields = true;
                }
                if (passwordInput.getText().toString().isEmpty()) {
                    passwordInput.setError("This field is required");
                    missingFields = true;
                }
                if (confirmpasswordInput.getText().toString().isEmpty()) {
                    confirmpasswordInput.setError("This field is required");
                    missingFields = true;
                }
                if (!checkbox.isChecked()) {
                    // Display a message or highlight the checkbox
                    Toast.makeText(Signup.this, "Please check the box to proceed", Toast.LENGTH_SHORT).show();
                    // Alternatively, you can add a visual cue to the checkbox itself
                    missingFields = true;
                }

                // Proceed only if there are no missing fields:
                if (!missingFields) {
                    Comparepassword();
                }
            }

            private void Comparepassword() {
                String pass = passwordInput.getText().toString();
                String pass2 = confirmpasswordInput.getText().toString();
                if (pass.equals(pass2)) {
                    addusertodatabase();
                } else {
                    // Inputs are different
                    Toast.makeText(Signup.this, "Password don't match!", Toast.LENGTH_SHORT).show();
                    // You can handle mismatches here, like highlighting mismatched fields
                }
            }

            private void addusertodatabase() {
                String fullname = fullnameInput.getText().toString().trim();
                String emailaddress = emailaddressInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                UsersInfo usersInfo = new UsersInfo(fullname,emailaddress,password);
                long result = dbHelper.addUsersInfo(usersInfo);

                if (result != -1) {
                    // Book added successfully
                    Toast.makeText(Signup.this, "Sign Up Successfully!", Toast.LENGTH_SHORT).show();
                    // Clear input fields for new entry
                    fullnameInput.setText("");
                    emailaddressInput.setText("");
                    passwordInput.setText("");
                    confirmpasswordInput.setText("");
                } else {
                    Toast.makeText(Signup.this, "Error Signing UP!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}