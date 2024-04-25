package com.example.cartimart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView clickablesignin;
    CheckBox checkbox;
    private Accountdatabase dbHelper;

    Button signinbutton;
    EditText emailaddressInput, passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        clickablesignin = findViewById(R.id.create_acc);
        clickablesignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, Signup.class);
                startActivity(intent);
            }
        });
        signinbutton = findViewById(R.id.login_button);
        emailaddressInput = findViewById(R.id.emailaddressInput);
        passwordInput = findViewById(R.id.passwordInput);
        dbHelper = new Accountdatabase(this);
        checkbox = findViewById(R.id.checkBox);

        signinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailaddressInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean isValid = validateLogin(email, password);
                if (isValid) {
                    // Successful login
                    // Navigate to the appropriate activity
                    Intent intent = new Intent(LoginActivity.this, dashboard.class); // Replace HomeActivity with your intended activity
                    startActivity(intent);
                } else {
                    // Invalid credentials
                    Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }

            private boolean validateLogin(String email, String password) {
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                String[] selectionArgs = new String[]{email, password};
                Cursor cursor = db.rawQuery("SELECT * FROM UserInfo WHERE email_address=? AND password=?", selectionArgs);

                boolean isValid = cursor.moveToFirst();
                cursor.close();
                db.close();
                return isValid;
            }
        });
    }
}