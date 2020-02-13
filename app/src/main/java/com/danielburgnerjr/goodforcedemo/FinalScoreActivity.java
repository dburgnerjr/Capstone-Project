package com.danielburgnerjr.goodforcedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.danielburgnerjr.goodforcedemo.model.Game;
import com.danielburgnerjr.goodforcedemo.model.User;
import com.google.gson.Gson;

public class FinalScoreActivity extends AppCompatActivity {

    Intent intU;
    private User usrU;
    Game gmG;
    private Gson gsonG;
    TextView txtYourScore;
    public SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);
        intU = getIntent();
        usrU = (User) intU.getSerializableExtra("User");
        gmG = (Game) intU.getSerializableExtra("Game");
        preferences = getSharedPreferences("default", Context.MODE_PRIVATE);
        txtYourScore = findViewById(R.id.txtYourScore);
        txtYourScore.setText(gmG.getScore());

        final Button btnPlayAgain = findViewById(R.id.btnPlayAgain);

        btnPlayAgain.setOnClickListener((View view) -> {
            Intent intA = new Intent(FinalScoreActivity.this, GameStartActivity.class);
            usrU.setGFPoints(usrU.getGFPoints() + 100);
            SharedPreferences.Editor e = preferences.edit();
            gsonG = new Gson();
            String strJson = gsonG.toJson(usrU);
            e.putString("User", strJson);
            e.apply();
            intA.putExtra("User", usrU);
            startActivity(intA);
            finish();
        });
    }
}
