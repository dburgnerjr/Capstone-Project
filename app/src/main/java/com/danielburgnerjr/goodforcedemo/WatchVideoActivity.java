package com.danielburgnerjr.goodforcedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.danielburgnerjr.goodforcedemo.model.Game;
import com.danielburgnerjr.goodforcedemo.model.User;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.gson.Gson;
import com.google.android.gms.ads.MobileAds;

public class WatchVideoActivity extends AppCompatActivity implements RewardedVideoAdListener {
    Intent intU;
    private User usrU;
    private Game gmG;
    private Gson gsonG;
    public SharedPreferences preferences;
    private RewardedVideoAd rvaVideoAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_video);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544~3347511713");
        preferences = getSharedPreferences("default", Context.MODE_PRIVATE);

        rvaVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        loadRewardedVideoAd();
        rvaVideoAd.show();

        intU = getIntent();
        usrU = (User) intU.getSerializableExtra("User");
        if (intU.getSerializableExtra("Game") != null) {
            gmG = (Game) intU.getSerializableExtra("Game");
        }
        final Button btnContinue = findViewById(R.id.btnContinue);
        final Button btnMainMenu = findViewById(R.id.btnMainMenu);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(WatchVideoActivity.this, FinalScoreActivity.class);
                usrU.setGFPoints(usrU.getGFPoints() + 1000);
                SharedPreferences.Editor e = preferences.edit();
                gsonG = new Gson();
                String strJson = gsonG.toJson(usrU);
                e.putString("User", strJson);
                e.apply();
                intA.putExtra("Game", gmG);
                intA.putExtra("User", usrU);
                startActivity(intA);
                finish();
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
                e.apply();
                intA.putExtra("User", usrU);
                startActivity(intA);
                finish();
            }
        });
    }

    private void loadRewardedVideoAd() {
        if (!rvaVideoAd.isLoaded()) {
            rvaVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917", new AdRequest.Builder().build());
        }
    }

    private void startVideoAd(View view) {
        if (rvaVideoAd.isLoaded()) {
            rvaVideoAd.show();
        }

    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onRewardedVideoCompleted() {

    }
}
