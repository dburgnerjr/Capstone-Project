package com.danielburgnerjr.goodforcedemo;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import com.danielburgnerjr.goodforcedemo.model.User;

public class TellFriendActivity extends AppCompatActivity {

    TextView txtGoodForceCode;
    Intent intQ;
    private User usrU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tell_friend);

        txtGoodForceCode = findViewById(R.id.txtGoodForceCode);

        intQ = getIntent();
        usrU = (User) intQ.getSerializableExtra("User");

        txtGoodForceCode.setText("GoodForce Code: " + usrU.getGoodForceCode());
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intI = new Intent(TellFriendActivity.this, GameStartActivity.class);
            intI.putExtra("User", usrU);
            startActivity(intI);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
