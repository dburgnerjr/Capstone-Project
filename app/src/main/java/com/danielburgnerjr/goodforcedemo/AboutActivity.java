package com.danielburgnerjr.goodforcedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intI = new Intent(AboutActivity.this, GameStartActivity.class);
            startActivity(intI);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
