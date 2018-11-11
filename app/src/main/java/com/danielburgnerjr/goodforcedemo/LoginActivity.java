package com.danielburgnerjr.goodforcedemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmailAddress;
    private EditText edtPassword;
    private Button btnLogin;
    private int nAttempts = 3;
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);   // NPE occurs here
    String strUsername = preferences.getString("username", "");
    String strPassword = preferences.getString("password", "");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton();
    }

    public void loginButton() {
        edtEmailAddress = (EditText)findViewById(R.id.edtEmailAddress);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(edtEmailAddress.getText().toString().equals(strUsername) &&
                                edtPassword.getText().toString().equals(strPassword)  ) {
                            Toast.makeText(LoginActivity.this, "User and Password is correct",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, GameStartActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "User and Password is not correct",
                                    Toast.LENGTH_SHORT).show();
                            nAttempts--;
                            if(nAttempts == 0) {
                                Toast.makeText(LoginActivity.this, "Please reset your password to continue",
                                        Toast.LENGTH_SHORT).show();
                                btnLogin.setEnabled(false);
                            }
                        }

                    }
                }
        );
    }

}
