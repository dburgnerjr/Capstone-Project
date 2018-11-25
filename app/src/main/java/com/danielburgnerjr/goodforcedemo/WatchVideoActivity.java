package com.danielburgnerjr.goodforcedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

public class WatchVideoActivity extends AppCompatActivity {
    private Intent intU;
    private User usrU;
    private Gson gsonG;
    public SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_video);
        preferences = getSharedPreferences("default", Context.MODE_PRIVATE);

        intU = getIntent();
        usrU = (User) intU.getSerializableExtra("User");
        final Button btnContinue = (Button) findViewById(R.id.btnContinue);
        final Button btnMainMenu = (Button) findViewById(R.id.btnMainMenu);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(WatchVideoActivity.this, FinalScoreActivity.class);
                usrU.setGFPoints(usrU.getGFPoints() + 1000);
                SharedPreferences.Editor e = preferences.edit();
                gsonG = new Gson();
                String strJson = gsonG.toJson(usrU);
                e.putString("User", strJson);
                e.commit();
                intA.putExtra("User", usrU);
                startActivity(intA);
                finish();
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
        btnMainMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(WatchVideoActivity.this, GameStartActivity.class);
                usrU.setGFPoints(usrU.getGFPoints() + 1000);
                SharedPreferences.Editor e = preferences.edit();
                gsonG = new Gson();
                String strJson = gsonG.toJson(usrU);
                e.putString("User", strJson);
                e.commit();
                intA.putExtra("User", usrU);
                startActivity(intA);
                finish();
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
