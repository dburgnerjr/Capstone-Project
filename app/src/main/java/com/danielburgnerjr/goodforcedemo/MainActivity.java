package com.danielburgnerjr.goodforcedemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends Activity {
    public SharedPreferences preferences;
    private String strJson;
    private Gson gsonG;
    private User usrU;
    private Intent intU;
    private Button btnBegin;
    private Button btnLogin;
    private Button btnRegister;

    private static int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        preferences = getSharedPreferences("default", Context.MODE_PRIVATE);
        gsonG = new Gson();
        strJson = preferences.getString("User", "");
        Toast.makeText(getApplicationContext(), strJson, Toast.LENGTH_SHORT).show();

        usrU = gsonG.fromJson(strJson, User.class);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBegin = (Button) findViewById(R.id.btnBegin);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        if (usrU != null) {
            startGameActivity(usrU);
        } else {
            intU = getIntent();
            usrU = (User) intU.getSerializableExtra("User");
        }

        btnBegin.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(MainActivity.this, GameStartActivity.class);
                startActivity(intA);
                finish();
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
        btnLogin.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(MainActivity.this, LoginActivity.class);
                intA.putExtra("User", usrU);
                startActivity(intA);
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
        btnRegister.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intA);
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void startGameActivity(final User usrU) {
        btnBegin.setVisibility(View.GONE);
        btnLogin.setVisibility(View.GONE);
        btnRegister.setVisibility(View.GONE);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(MainActivity.this, GameStartActivity.class);
                i.putExtra("User", usrU);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}