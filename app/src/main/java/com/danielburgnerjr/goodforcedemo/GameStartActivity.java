package com.danielburgnerjr.goodforcedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameStartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);

        final Button btnPlay = (Button) findViewById(R.id.btnPlay);
        final Button btnGameRules = (Button) findViewById(R.id.btnGameRules);
        final Button btnExtraLives = (Button) findViewById(R.id.btnExtraLives);
        final Button btnWatchVideo = (Button) findViewById(R.id.btnWatchVideo);
        final Button btnGoodForceCoins = (Button) findViewById(R.id.btnGoodForceCoins);
        final Button btnInvite = (Button) findViewById(R.id.btnInvite);
        final Button btnGFPoints = (Button) findViewById(R.id.btnGFPoints);
        final Button btnAbout = (Button) findViewById(R.id.btnAbout);
        final Button btnLogout = (Button) findViewById(R.id.btnLogout);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(GameStartActivity.this, QuestionActivity.class);
                startActivity(intA);
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
        btnGameRules.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(GameStartActivity.this, GameRulesActivity.class);
                startActivity(intA);
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
        btnExtraLives.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(GameStartActivity.this, ExtraLivesActivity.class);
                startActivity(intA);
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
        btnWatchVideo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(GameStartActivity.this, WatchVideoActivity.class);
                startActivity(intA);
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
        btnGoodForceCoins.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(GameStartActivity.this, CoinsActivity.class);
                startActivity(intA);
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
        btnInvite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(GameStartActivity.this, TellFriendActivity.class);
                startActivity(intA);
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
        btnGFPoints.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(GameStartActivity.this, PointsActivity.class);
                startActivity(intA);
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(GameStartActivity.this, AboutActivity.class);
                startActivity(intA);
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(GameStartActivity.this, LogoutActivity.class);
                startActivity(intA);
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
