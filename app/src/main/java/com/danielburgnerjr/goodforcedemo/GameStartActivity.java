package com.danielburgnerjr.goodforcedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.danielburgnerjr.goodforcedemo.model.User;

public class GameStartActivity extends Activity {

    private Intent intU;
    private User usrU;
    private TextView txtPlayerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);

        txtPlayerId = (TextView) findViewById(R.id.txtPlayerId);
        final Button btnPlay = (Button) findViewById(R.id.btnPlay);
        final Button btnGameRules = (Button) findViewById(R.id.btnGameRules);
        final Button btnExtraLives = (Button) findViewById(R.id.btnExtraLives);
        final Button btnWatchVideo = (Button) findViewById(R.id.btnWatchVideo);
        final Button btnGoodForceCoins = (Button) findViewById(R.id.btnGoodForceCoins);
        final Button btnInvite = (Button) findViewById(R.id.btnInvite);
        final Button btnGFPoints = (Button) findViewById(R.id.btnGFPoints);
        final Button btnAbout = (Button) findViewById(R.id.btnAbout);
        final Button btnLogout = (Button) findViewById(R.id.btnLogout);
        intU = getIntent();
        usrU = (User) intU.getSerializableExtra("User");
        if (usrU == null) {
            txtPlayerId.setText("Welcome No User #0");
            btnExtraLives.setText("No Extra Lives");
            btnGoodForceCoins.setText("No Coins");
            btnGFPoints.setText("No Points");
            btnPlay.setEnabled(false);
            btnExtraLives.setEnabled(false);
            btnGoodForceCoins.setEnabled(false);
            btnGFPoints.setEnabled(false);
            btnInvite.setEnabled(false);
            btnWatchVideo.setEnabled(false);
            btnLogout.setEnabled(false);
        } else {
            txtPlayerId.setText("Welcome " + usrU.getFirstName() + ", #" + usrU.getPlayerNumber());
            btnExtraLives.setText("Extra Lives: " + usrU.getExtraLives());
            btnGoodForceCoins.setText("Coins: " + usrU.getCoins());
            btnGFPoints.setText("Points: " + usrU.getGFPoints());
        }

        btnPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(GameStartActivity.this, QuestionActivity.class);
                intA.putExtra("User", usrU);
                startActivity(intA);
                finish();
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
        btnGameRules.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(GameStartActivity.this, GameRulesActivity.class);
                startActivity(intA);
                finish();
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
        btnExtraLives.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(GameStartActivity.this, ExtraLivesActivity.class);
                intA.putExtra("User", usrU);
                startActivity(intA);
                finish();
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
        btnWatchVideo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(GameStartActivity.this, WatchVideoActivity.class);
                intA.putExtra("User", usrU);
                startActivity(intA);
                finish();
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
        btnGoodForceCoins.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(GameStartActivity.this, CoinsActivity.class);
                intA.putExtra("User", usrU);
                startActivity(intA);
                finish();
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
        btnInvite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(GameStartActivity.this, TellFriendActivity.class);
                intA.putExtra("User", usrU);
                startActivity(intA);
                finish();
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
        btnGFPoints.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(GameStartActivity.this, PointsActivity.class);
                intA.putExtra("User", usrU);
                startActivity(intA);
                finish();
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(GameStartActivity.this, AboutActivity.class);
                intA.putExtra("User", usrU);
                startActivity(intA);
                finish();
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(GameStartActivity.this, LogoutActivity.class);
                intA.putExtra("User", usrU);
                startActivity(intA);
                finish();
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
