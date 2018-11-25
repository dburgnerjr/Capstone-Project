package com.danielburgnerjr.goodforcedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

public class FinalScoreActivity extends AppCompatActivity {

    private Intent intU;
    private User usrU;
    private Gson gsonG;
    public SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);
        intU = getIntent();
        usrU = (User) intU.getSerializableExtra("User");
        preferences = getSharedPreferences("default", Context.MODE_PRIVATE);

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
