package com.example.barkitproject;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    //set delay duration in milliseconds(2000=2sec)
    private static final int SPLASH_DELAY = 2000;

    private static final String TRANSITION_NAME = "bulldog_transition";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        View decorView = getWindow().getDecorView();
        decorView.postDelayed(this::startLoginActivityWithTransition, SPLASH_DELAY);
    }

    private void startLoginActivityWithTransition() {
        if (isFinishing()) {
            return;
        }
        ImageView bulldogImageView = findViewById(R.id.bulldog2);
        Intent intent = new Intent(SplashActivity.this, AuthPageActivity.class);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                this,
                Pair.create((View) bulldogImageView, TRANSITION_NAME)
        );
        startActivity(intent, options.toBundle());
        finish();
    }
}
