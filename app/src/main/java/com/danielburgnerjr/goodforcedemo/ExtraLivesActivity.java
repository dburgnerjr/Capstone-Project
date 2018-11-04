package com.danielburgnerjr.goodforcedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

public class ExtraLivesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_lives);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intI = new Intent(ExtraLivesActivity.this, GameStartActivity.class);
            startActivity(intI);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
