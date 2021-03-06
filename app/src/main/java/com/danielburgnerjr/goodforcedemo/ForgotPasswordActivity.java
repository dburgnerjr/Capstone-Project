package com.danielburgnerjr.goodforcedemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText edtEmailAddressPW;
    Button btnResetPW;
    Button btnBackLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        edtEmailAddressPW = findViewById(R.id.edtEmailAddressPW);
        btnResetPW = findViewById(R.id.btnResetPW);
        btnBackLogin = findViewById(R.id.btnBackLogin);

        final String strEmailAddressPW = edtEmailAddressPW.getText().toString();
        btnResetPW.setOnClickListener((View view) -> {
            String[] TO = {strEmailAddressPW};
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setDataAndType(Uri.parse("mailto:"), "text/plain");

            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "GoodForceDemo Forgot Password");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Your email address is: " + strEmailAddressPW);
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Your new password is: lilyvang0rd3r");

            try {
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                Log.i("Finished sending email.", "");
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(ForgotPasswordActivity.this,
                        "There is no email client installed.", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(ForgotPasswordActivity.this, "Email will be sent to email address on file.",
                    Toast.LENGTH_SHORT).show();
        });

        btnBackLogin.setOnClickListener((View view) -> {
            Intent intA = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
            startActivity(intA);
            finish();
        });

    }
}
