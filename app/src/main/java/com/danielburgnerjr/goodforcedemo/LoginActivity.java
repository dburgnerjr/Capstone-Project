package com.danielburgnerjr.goodforcedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.danielburgnerjr.goodforcedemo.model.User;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmailAddress;
    private EditText edtPassword;
    private Button btnLogin;
    Button btnForgotPW;
    private int nAttempts = 3;
    Intent intU;
    private User usrU;
    public SharedPreferences preferences;
    private String strJson;
    private Gson gsonG;
    private String strUsername;
    private String strPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferences = getSharedPreferences("default", Context.MODE_PRIVATE);
        gsonG = new Gson();
        strJson = preferences.getString("User", "");
        usrU = gsonG.fromJson(strJson, User.class);
        Log.d("blah", "onClick: " + strJson);

        loginButton();
    }

    public void loginButton() {
        edtEmailAddress = findViewById(R.id.edtEmailAddress);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnForgotPW = findViewById(R.id.btnForgotPW);

        intU = getIntent();
        if (usrU == null)
            usrU = (User) intU.getSerializableExtra("User");
        if (usrU != null) {
            strUsername = usrU.getEmailAddress();
            strPassword = usrU.getPassword();
        }
        btnLogin.setOnClickListener(
                (View v) -> {
                    if (edtEmailAddress.getText().toString().equals(strUsername) && edtPassword.getText().toString().equals(strPassword)) {
                        Toast.makeText(LoginActivity.this, "User and Password is correct",
                                Toast.LENGTH_SHORT).show();
                        if (strJson.trim().equals("")) {
                            SharedPreferences.Editor e = preferences.edit();
                            strJson = gsonG.toJson(usrU);
                            e.putString("User", strJson);
                            e.apply();
                        }
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
                        if (nAttempts == 0) {
                            Toast.makeText(LoginActivity.this, "Please reset your password to continue",
                                    Toast.LENGTH_SHORT).show();
                            btnLogin.setEnabled(false);
                        }
                    }
                }
        );

        btnForgotPW.setOnClickListener((View view) ->{
            Intent intA = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
            startActivity(intA);
            finish();
        });
    }
}
