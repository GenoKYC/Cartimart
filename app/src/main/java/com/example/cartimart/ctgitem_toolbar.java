package com.example.cartimart;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ctgitem_toolbar extends AppCompatActivity {

        SharedPreferences sharedPref;
    protected void setupToolbar(String title) {
        // Find toolbar views
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        ImageView leftIcon = findViewById(R.id.left_icon);

        // Set title
        toolbarTitle.setText(title);
        String senddata = "send";
        // Handle back button click
        leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("data", senddata);
                editor.apply();
*/
                Intent intent = new Intent(ctgitem_toolbar.this, About.class);
                intent.putExtra("data",senddata);
                //finish(); // Finish the current activity and return to the previous one
            }
        });
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctgitem_toolbar );
        // You can put additional setup code common to all activities here
    }
}
