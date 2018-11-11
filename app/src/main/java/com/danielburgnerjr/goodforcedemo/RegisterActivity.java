package com.danielburgnerjr.goodforcedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {

    EditText edtFirstName;
    EditText edtLastName;
    EditText edtEmailAddress;
    EditText edtPassword;
    EditText edtConfirmPassword;
    EditText edtZipCode;
    Button btnRegister;
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    String strUsername;
    String strPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

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
                    strUsername = edtEmailAddress.getText().toString();
                    strPassword = edtPassword.getText().toString();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    Editor e = getPreferences(Context.MODE_PRIVATE).edit();
                    e.putString("username", strUsername);
                    e.putString("password", strPassword);
                    e.commit();
                    intent.putExtra("username", strUsername);
                    intent.putExtra("password", strPassword);
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
