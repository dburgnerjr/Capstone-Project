package com.danielburgnerjr.goodforcedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;

import com.danielburgnerjr.goodforcedemo.model.User;


public class LogoutActivity extends AppCompatActivity {
    public SharedPreferences preferences;

    static int SPLASH_TIME_OUT = 5000;
    Intent intU;
    private User usrU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        preferences = getSharedPreferences("default", Context.MODE_PRIVATE);
        intU = getIntent();
        usrU = (User) intU.getSerializableExtra("User");

        SharedPreferences.Editor e = preferences.edit();
        e.clear();
        e.apply();

        /*
         * Showing splash screen with a timer. This will be useful when you
         * want to show case your app logo / company
         */
        new Handler().postDelayed(() -> {
            // This method will be executed once the timer is over
            // Start your app main activity
            Intent i = new Intent(LogoutActivity.this, MainActivity.class);
            i.putExtra("User", usrU);
            startActivity(i);

            // close this activity
            finish();
        }, SPLASH_TIME_OUT);
    }
}
