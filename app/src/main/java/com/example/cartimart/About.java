package com.example.cartimart;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class About extends AppCompatActivity {
    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
       /* sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String Rdata = sharedPref.getString("data", "data2");
        // Get the ActionBar
*/
        Intent intent = getIntent();
        String Rdata = intent.getStringExtra("data");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                assert Rdata != null;
                if(Rdata.equals("data")){
                    finish();
                }
            }
        },100);



    }
}
