package com.danielburgnerjr.goodforcedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuestionActivity extends Activity {

    private TextView txtQuestion;
    private TextView txtQuestionValue;
    private TextView txtScore;
    private TextView txtTimer;
    private Button btnTrue;
    private Button btnFalse;
    private CountDownTimer mCountDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        txtQuestionValue = (TextView) findViewById(R.id.txtQuestionValue);
        txtScore = (TextView) findViewById(R.id.txtScore);
        txtTimer = (TextView) findViewById(R.id.txtTimer);
        btnTrue = (Button) findViewById(R.id.btnTrue);
        btnFalse = (Button) findViewById(R.id.btnFalse);

        txtQuestion.setText("This is a sample question");
        txtQuestionValue.setText("10 Points");
        txtScore.setText("0");
        txtTimer.setText("10");

        mCountDown = new CountDownTimer(10000, 1000) {

            @Override
            public void onFinish() {
                Intent intA = new Intent(QuestionActivity.this, AnswerActivity.class);
                startActivity(intA);
                finish();
            }

            // OnClickListener not working and playing well with CountDownTimer
            btnTrue.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intA = new Intent(QuestionActivity.this, AnswerActivity.class);
                    startActivity(intA);
                    finish();
                    //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
                }
            });

            btnFalse.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intA = new Intent(QuestionActivity.this, AnswerActivity.class);
                    startActivity(intA);
                    finish();
                    //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
                }
            });

            @Override
            public void onTick(long millisUntilFinished) {
                txtTimer.setText(String.valueOf(millisUntilFinished / 1000));
            }
        }.start();
    }

}
