package com.danielburgnerjr.goodforcedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.danielburgnerjr.goodforcedemo.model.User;
import com.google.gson.Gson;

public class CoinsActivity extends AppCompatActivity {

    Intent intU;
    private User usrU;
    private Gson gsonG;
    public SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coins);
        intU = getIntent();
        usrU = (User) intU.getSerializableExtra("User");
        preferences = getSharedPreferences("default", Context.MODE_PRIVATE);

        final Button btnOneCoin = findViewById(R.id.btnOneCoin);
        final Button btnFiveCoins = findViewById(R.id.btnFiveCoins);
        final Button btnTenCoins = findViewById(R.id.btnTenCoins);
        final Button btnTwentyCoins = findViewById(R.id.btnTwentyCoins);
        final Button btnFiftyCoins = findViewById(R.id.btnFiftyCoins);
        final Button btn100Coins = findViewById(R.id.btn100Coins);

        btnOneCoin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(CoinsActivity.this, GameStartActivity.class);
                usrU.setCoins(usrU.getCoins() + 1);
                usrU.setGFPoints(usrU.getGFPoints() + 500);
                SharedPreferences.Editor e = preferences.edit();
                gsonG = new Gson();
                String strJson = gsonG.toJson(usrU);
                e.putString("User", strJson);
                e.apply();
                intA.putExtra("User", usrU);
                startActivity(intA);
                finish();
            }
        });
        btnFiveCoins.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(CoinsActivity.this, GameStartActivity.class);
                usrU.setCoins(usrU.getCoins() + 5);
                usrU.setGFPoints(usrU.getGFPoints() + 2500);
                SharedPreferences.Editor e = preferences.edit();
                gsonG = new Gson();
                String strJson = gsonG.toJson(usrU);
                e.putString("User", strJson);
                e.apply();
                intA.putExtra("User", usrU);
                startActivity(intA);
                finish();
            }
        });
        btnTenCoins.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(CoinsActivity.this, GameStartActivity.class);
                usrU.setCoins(usrU.getCoins() + 10);
                usrU.setGFPoints(usrU.getGFPoints() + 5000);
                SharedPreferences.Editor e = preferences.edit();
                gsonG = new Gson();
                String strJson = gsonG.toJson(usrU);
                e.putString("User", strJson);
                e.apply();
                intA.putExtra("User", usrU);
                startActivity(intA);
                finish();
            }
        });
        btnTwentyCoins.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(CoinsActivity.this, GameStartActivity.class);
                usrU.setCoins(usrU.getCoins() + 20);
                usrU.setGFPoints(usrU.getGFPoints() + 10000);
                SharedPreferences.Editor e = preferences.edit();
                gsonG = new Gson();
                String strJson = gsonG.toJson(usrU);
                e.putString("User", strJson);
                e.apply();
                intA.putExtra("User", usrU);
                startActivity(intA);
                finish();
            }
        });
        btnFiftyCoins.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(CoinsActivity.this, GameStartActivity.class);
                usrU.setCoins(usrU.getCoins() + 50);
                usrU.setGFPoints(usrU.getGFPoints() + 25000);
                SharedPreferences.Editor e = preferences.edit();
                gsonG = new Gson();
                String strJson = gsonG.toJson(usrU);
                e.putString("User", strJson);
                e.apply();
                intA.putExtra("User", usrU);
                startActivity(intA);
                finish();
            }
        });
        btn100Coins.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(CoinsActivity.this, GameStartActivity.class);
                usrU.setCoins(usrU.getCoins() + 100);
                usrU.setGFPoints(usrU.getGFPoints() + 50000);
                SharedPreferences.Editor e = preferences.edit();
                gsonG = new Gson();
                String strJson = gsonG.toJson(usrU);
                e.putString("User", strJson);
                e.apply();
                intA.putExtra("User", usrU);
                startActivity(intA);
                finish();
            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intI = new Intent(CoinsActivity.this, GameStartActivity.class);
            intI.putExtra("User", usrU);
            startActivity(intI);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
