package com.danielburgnerjr.goodforcedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnBegin = (Button) findViewById(R.id.btnBegin);
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final Button btnRegister = (Button) findViewById(R.id.btnRegister);

        btnBegin.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(MainActivity.this, GameStartActivity.class);
                startActivity(intA);
                finish();
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
        btnLogin.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intA);
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
        btnRegister.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intA);
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });
    }
}