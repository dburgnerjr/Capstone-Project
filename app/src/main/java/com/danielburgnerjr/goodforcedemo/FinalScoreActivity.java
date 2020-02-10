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

    private Intent intU;
    private User usrU;
    private Game gmG;
    private Gson gsonG;
    private TextView txtYourScore;
    public SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);
        intU = getIntent();
        usrU = (User) intU.getSerializableExtra("User");
        gmG = (Game) intU.getSerializableExtra("Game");
        preferences = getSharedPreferences("default", Context.MODE_PRIVATE);
        txtYourScore = (TextView) findViewById(R.id.txtYourScore);
        txtYourScore.setText("" + gmG.getScore());

        final Button btnPlayAgain = (Button) findViewById(R.id.btnPlayAgain);

        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(FinalScoreActivity.this, GameStartActivity.class);
                usrU.setGFPoints(usrU.getGFPoints() + 100);
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
