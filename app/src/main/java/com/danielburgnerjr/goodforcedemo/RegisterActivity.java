package com.danielburgnerjr.goodforcedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtFirstName;
    private EditText edtLastName;
    private EditText edtEmailAddress;
    private EditText edtPassword;
    private EditText edtConfirmPassword;
    private EditText edtZipCode;
    private Button btnRegister;
    private String strFirstName;
    private String strLastName;
    private String strUsername;
    private String strPassword;
    private String strZipCode;
    private User usrU;
    private Gson gsonG;
    public SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        preferences = getSharedPreferences("default", Context.MODE_PRIVATE);

        edtFirstName = findViewById(R.id.edtFirstName);
        edtLastName = findViewById(R.id.edtLastName);
        edtEmailAddress = findViewById(R.id.edtEmailAddress);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        edtZipCode = findViewById(R.id.edtZipCode);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean bDataCheck = checkDataEntered();
                if (bDataCheck == true) {
                    usrU = new User();
                    strFirstName = edtFirstName.getText().toString();
                    usrU.setFirstName(strFirstName);
                    strLastName = edtLastName.getText().toString();
                    usrU.setLastName(strLastName);
                    strUsername = edtEmailAddress.getText().toString();
                    usrU.setEmailAddress(strUsername);
                    strPassword = edtPassword.getText().toString();
                    usrU.setPassword(strPassword);
                    strZipCode = edtZipCode.getText().toString();
                    usrU.setZipCode(strZipCode);
                    usrU.setPlayerNumber(1);
                    usrU.setCoins(2);
                    usrU.setExtraLives(2);
                    usrU.setGFPoints(100);
                    usrU.setGoodForceCode("DB105244");
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    SharedPreferences.Editor e = preferences.edit();
                    gsonG = new Gson();
                    String strJson = gsonG.toJson(usrU);
                    e.putString("User", strJson);
                    e.commit();
                    intent.putExtra("User", usrU);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isPasswordMatch(EditText textLeft, EditText textRight) {
        CharSequence csPassword = textLeft.getText().toString();
        CharSequence csPasswordRight = textRight.getText().toString();
        return (!csPassword.equals(csPasswordRight));
    }

    boolean checkDataEntered() {
        if (isEmpty(edtFirstName)) {
            Toast tT = Toast.makeText(this, "You must enter a first name to register!", Toast.LENGTH_SHORT);
            tT.show();
            return false;
        } else if (isEmpty(edtLastName)) {
            Toast tT = Toast.makeText(this, "You must enter a last name to register!", Toast.LENGTH_SHORT);
            tT.show();
            return false;
        } else if (isEmail(edtEmailAddress) == false) {
            Toast tT = Toast.makeText(this, "You must enter a valid email address!", Toast.LENGTH_SHORT);
            tT.show();
            return false;
        } else if (isEmpty(edtPassword)) {
            Toast tT = Toast.makeText(this, "You must enter a password to register!", Toast.LENGTH_SHORT);
            tT.show();
            return false;
        } else if (isEmpty(edtConfirmPassword)) {
            Toast tT = Toast.makeText(this, "You must enter the password again to register!", Toast.LENGTH_SHORT);
            tT.show();
            return false;
        } else if (isPasswordMatch(edtPassword, edtConfirmPassword)) {
            Toast tT = Toast.makeText(this, "The passwords must match.", Toast.LENGTH_SHORT);
            tT.show();
            return false;
        } else if (isEmpty(edtZipCode)) {
            Toast tT = Toast.makeText(this, "You must enter the zip code to register!", Toast.LENGTH_SHORT);
            tT.show();
            return false;
        } else {
            return true;
        }
    }
}
