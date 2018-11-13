package com.danielburgnerjr.goodforcedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmailAddress;
    private EditText edtPassword;
    private Button btnLogin;
    private Button btnForgotPW;
    private int nAttempts = 3;
    private Intent intU;
    private User usrU;
    public SharedPreferences preferences;   
    private String strUsername;
    private String strPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferences = getSharedPreferences("default", Context.MODE_PRIVATE);
        strUsername = preferences.getString("username", "");
        strPassword = preferences.getString("password", "");
        Log.d("blah", "onClick: " + strUsername + " " + strPassword);

        loginButton();
    }

    public void loginButton() {
        edtEmailAddress = (EditText)findViewById(R.id.edtEmailAddress);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnForgotPW = (Button)findViewById(R.id.btnForgotPW);

        intU = getIntent();
        usrU = (User) intU.getSerializableExtra("User");
        btnLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(edtEmailAddress.getText().toString().equals(strUsername) && edtPassword.getText().toString().equals(strPassword)) {
                            Toast.makeText(LoginActivity.this, "User and Password is correct",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, GameStartActivity.class);
                            intent.putExtra("User", usrU);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "User and Password is not correct",
                                    Toast.LENGTH_SHORT).show();
                            Toast.makeText(LoginActivity.this, "Username is" + strUsername,
                                    Toast.LENGTH_SHORT).show();
                            Toast.makeText(LoginActivity.this, "Password is" + strPassword,
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

        btnForgotPW.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intA);
                finish();
            }
        });

    }

}
