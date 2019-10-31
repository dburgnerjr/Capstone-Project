package com.danielburgnerjr.goodforcedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

public class ExtraLivesActivity extends AppCompatActivity {

    private Intent intU;
    private User usrU;
    private Gson gsonG;
    public SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_lives);
        intU = getIntent();
        usrU = (User) intU.getSerializableExtra("User");
        preferences = getSharedPreferences("default", Context.MODE_PRIVATE);

        final Button btnOneExtraLife = (Button) findViewById(R.id.btnOneExtraLife);
        final Button btnTwoExtraLives = (Button) findViewById(R.id.btnTwoExtraLives);
        final Button btnThreeExtraLives = (Button) findViewById(R.id.btnThreeExtraLives);
        final Button btnFourExtraLives = (Button) findViewById(R.id.btnFourExtraLives);
        final Button btnFiveExtraLives = (Button) findViewById(R.id.btnFiveExtraLives);
        final Button btnTenExtraLives = (Button) findViewById(R.id.btnTenExtraLives);

        btnOneExtraLife.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(ExtraLivesActivity.this, GameStartActivity.class);
                usrU.setExtraLives(usrU.getExtraLives() + 1);
                usrU.setGFPoints(usrU.getGFPoints() + 500);
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
        btnTwoExtraLives.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(ExtraLivesActivity.this, GameStartActivity.class);
                usrU.setExtraLives(usrU.getExtraLives() + 2);
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
        btnThreeExtraLives.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(ExtraLivesActivity.this, GameStartActivity.class);
                usrU.setExtraLives(usrU.getExtraLives() + 3);
                usrU.setGFPoints(usrU.getGFPoints() + 1500);
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
        btnFourExtraLives.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(ExtraLivesActivity.this, GameStartActivity.class);
                usrU.setExtraLives(usrU.getExtraLives() + 4);
                usrU.setGFPoints(usrU.getGFPoints() + 2000);
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
        btnFiveExtraLives.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(ExtraLivesActivity.this, GameStartActivity.class);
                usrU.setExtraLives(usrU.getExtraLives() + 5);
                usrU.setGFPoints(usrU.getGFPoints() + 2500);
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
        btnTenExtraLives.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(ExtraLivesActivity.this, GameStartActivity.class);
                usrU.setExtraLives(usrU.getExtraLives() + 10);
                usrU.setGFPoints(usrU.getGFPoints() + 5000);
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

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intI = new Intent(ExtraLivesActivity.this, GameStartActivity.class);
            intI.putExtra("User", usrU);
            startActivity(intI);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
