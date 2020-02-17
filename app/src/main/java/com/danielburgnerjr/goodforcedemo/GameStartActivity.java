package com.danielburgnerjr.goodforcedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.danielburgnerjr.goodforcedemo.model.User;

public class GameStartActivity extends Activity {

    Intent intU;
    private User usrU;
    TextView txtPlayerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);

        txtPlayerId = findViewById(R.id.txtPlayerId);
        final Button btnPlay = findViewById(R.id.btnPlay);
        final Button btnGameRules = findViewById(R.id.btnGameRules);
        final Button btnExtraLives = findViewById(R.id.btnExtraLives);
        final Button btnWatchVideo = findViewById(R.id.btnWatchVideo);
        final Button btnGoodForceCoins = findViewById(R.id.btnGoodForceCoins);
        final Button btnInvite = findViewById(R.id.btnInvite);
        final Button btnGFPoints = findViewById(R.id.btnGFPoints);
        final Button btnAbout = findViewById(R.id.btnAbout);
        final Button btnLogout = findViewById(R.id.btnLogout);
        intU = getIntent();
        usrU = (User) intU.getSerializableExtra("User");
        String strWelcome = "Welcome ";
        String strUserNum = "#";
        String strExtraLives = "Extra Lives: ";
        String strCoins = "Coins: ";
        String strPoints = "Points: ";
        if (usrU == null) {
            strWelcome = strWelcome + strUserNum + "0";
            strExtraLives += "0";
            strCoins += "0";
            strPoints += "0";
            btnPlay.setEnabled(false);
            btnExtraLives.setEnabled(false);
            btnGoodForceCoins.setEnabled(false);
            btnGFPoints.setEnabled(false);
            btnInvite.setEnabled(false);
            btnWatchVideo.setEnabled(false);
            btnLogout.setEnabled(false);
        } else {
            strWelcome = strWelcome + usrU.getFirstName() + " " + usrU.getLastName() + "," + strUserNum + usrU.getPlayerNumber();
            strExtraLives += usrU.getExtraLives();
            strCoins += usrU.getCoins();
            strPoints += usrU.getGFPoints();
        }
        txtPlayerId.setText(strWelcome);
        btnExtraLives.setText(strExtraLives);
        btnGoodForceCoins.setText(strCoins);
        btnGFPoints.setText(strPoints);

        btnPlay.setOnClickListener((View view) -> {
            Intent intA = new Intent(GameStartActivity.this, QuestionActivity.class);
            intA.putExtra("User", usrU);
            startActivity(intA);
            finish();
        });
        btnGameRules.setOnClickListener((View view) -> {
            Intent intA = new Intent(GameStartActivity.this, GameRulesActivity.class);
            startActivity(intA);
            finish();
        });
        btnExtraLives.setOnClickListener((View view) -> {
            Intent intA = new Intent(GameStartActivity.this, ExtraLivesActivity.class);
            intA.putExtra("User", usrU);
            startActivity(intA);
            finish();
        });
        btnWatchVideo.setOnClickListener((View view) -> {
            Intent intA = new Intent(GameStartActivity.this, WatchVideoActivity.class);
            intA.putExtra("User", usrU);
            startActivity(intA);
            finish();
        });
        btnGoodForceCoins.setOnClickListener((View view) -> {
            Intent intA = new Intent(GameStartActivity.this, CoinsActivity.class);
            intA.putExtra("User", usrU);
            startActivity(intA);
            finish();
        });
        btnInvite.setOnClickListener((View view) -> {
            Intent intA = new Intent(GameStartActivity.this, TellFriendActivity.class);
            intA.putExtra("User", usrU);
            startActivity(intA);
            finish();
        });
        btnGFPoints.setOnClickListener((View view) -> {
            Intent intA = new Intent(GameStartActivity.this, PointsActivity.class);
            intA.putExtra("User", usrU);
            startActivity(intA);
            finish();
        });
        btnAbout.setOnClickListener((View view) -> {
            Intent intA = new Intent(GameStartActivity.this, AboutActivity.class);
            intA.putExtra("User", usrU);
            startActivity(intA);
            finish();
        });
        btnLogout.setOnClickListener((View view) -> {
            Intent intA = new Intent(GameStartActivity.this, LogoutActivity.class);
            intA.putExtra("User", usrU);
            startActivity(intA);
            finish();
        });
    }
}
