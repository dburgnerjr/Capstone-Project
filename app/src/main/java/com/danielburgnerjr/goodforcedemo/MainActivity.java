package com.danielburgnerjr.goodforcedemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.danielburgnerjr.goodforcedemo.model.User;
import com.google.gson.Gson;

public class MainActivity extends Activity {
    public SharedPreferences preferences;
    String strJson;
    Gson gsonG;
    private User usrU;
    Intent intU;
    private Button btnBegin;
    private Button btnLogin;
    private Button btnRegister;

    static int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        preferences = getSharedPreferences("default", Context.MODE_PRIVATE);
        gsonG = new Gson();
        strJson = preferences.getString("User", "");

        usrU = gsonG.fromJson(strJson, User.class);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBegin = findViewById(R.id.btnBegin);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        if (usrU != null) {
            startGameActivity(usrU);
        } else {
            intU = getIntent();
            usrU = (User) intU.getSerializableExtra("User");
        }

        btnBegin.setOnClickListener((View view) -> {
            Intent intA = new Intent(MainActivity.this, GameStartActivity.class);
            startActivity(intA);
            finish();
        });
        btnLogin.setOnClickListener((View view) -> {
            Intent intA = new Intent(MainActivity.this, LoginActivity.class);
            intA.putExtra("User", usrU);
            startActivity(intA);
        });
        btnRegister.setOnClickListener((View view) -> {
            Intent intA = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intA);
        });
    }

    protected void startGameActivity(final User usrU) {
        btnBegin.setVisibility(View.GONE);
        btnLogin.setVisibility(View.GONE);
        btnRegister.setVisibility(View.GONE);

        /*
         * Showing splash screen with a timer. This will be useful when you
         * want to show case your app logo / company
         */
        new Handler().postDelayed(() -> {
            // This method will be executed once the timer is over
            // Start your app main activity
            Intent i = new Intent(MainActivity.this, GameStartActivity.class);
            i.putExtra("User", usrU);
            startActivity(i);

            // close this activity
            finish();
        }, SPLASH_TIME_OUT);
    }
}
