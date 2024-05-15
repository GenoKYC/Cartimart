package com.example.cartimart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Address extends AppCompatActivity {

    EditText locationInput, blockInput, contactInput, nameAddressInput;
    Button btnsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaddress);

        locationInput = findViewById(R.id.location_input);
        blockInput = findViewById(R.id.block_input);
        contactInput = findViewById(R.id.Contact_input);
        nameAddressInput = findViewById(R.id.Name_address_input);

        btnsubmit = findViewById(R.id.AddressbuttonSubmit);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"input " + locationInput.getText(), Toast.LENGTH_SHORT).show();
                //call update profile
            }
        });

    }
}