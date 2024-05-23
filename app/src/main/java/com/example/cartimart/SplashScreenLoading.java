package com.example.cartimart;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.cartimart.R;

public class SplashScreenLoading extends AppCompatActivity {

    private static final int SPLASH_TIME_MS = 3000;  // Set your splash screen duration

    private View dot1, dot2, dot3, dot4;
    private AnimatorSet animationSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_loading);

        dot1 = findViewById(R.id.dot1);
        dot2 = findViewById(R.id.dot2);
        dot3 = findViewById(R.id.dot3);
        dot4 = findViewById(R.id.dot4);


        createAnimation();
        animationSet.start();

        // Simulate some background work (replace with your actual initialization)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Launch your main activity or perform any necessary actions
                Intent intent  =new Intent(SplashScreenLoading.this, NotesListAct.class);
                startActivity(intent);
                finish();  // Close the splash screen activity
            }
        }, SPLASH_TIME_MS);
    }
    private void createAnimation() {
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(dot1, "alpha", 0f, 1f);
        anim1.setDuration(500);
        anim1.setRepeatCount(ObjectAnimator.INFINITE);
        anim1.setRepeatMode(ObjectAnimator.REVERSE);

        ObjectAnimator anim2 = ObjectAnimator.ofFloat(dot2, "alpha", 0f, 1f);
        anim2.setDuration(500);
        anim2.setStartDelay(200);
        anim2.setRepeatCount(ObjectAnimator.INFINITE);
        anim2.setRepeatMode(ObjectAnimator.REVERSE);

        ObjectAnimator anim3 = ObjectAnimator.ofFloat(dot3, "alpha", 0f, 1f);
        anim3.setDuration(500);
        anim3.setStartDelay(400);
        anim3.setRepeatCount(ObjectAnimator.INFINITE);
        anim3.setRepeatMode(ObjectAnimator.REVERSE);

        ObjectAnimator anim4 = ObjectAnimator.ofFloat(dot4, "alpha", 0f, 1f);
        anim4.setDuration(500);
        anim4.setStartDelay(600);
        anim4.setRepeatCount(ObjectAnimator.INFINITE);
        anim4.setRepeatMode(ObjectAnimator.REVERSE);

        animationSet = new AnimatorSet();
        animationSet.playTogether(anim1, anim2, anim3);
    }



}