package com.danielburgnerjr.goodforcedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class QuestionActivity extends Activity {

    private TextView txtQuestion;
    private TextView txtQuestionValue;
    private TextView txtScore;
    private TextView txtTimer;
    private Button btnTrue;
    private Button btnFalse;
    private boolean bCorrectAnswer;
    private boolean bYourAnswer;
    private int nStrikes;
    private int nQuestionNumber;
    private int nPlayerNumber;
    private int nExtraLives;
    private boolean bExtraLifeUsed;
    private int nScore;
    private CountDownTimer mCountDown;
    private Intent intQ;
    private User usrU;
    private Game gmG;

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

        intQ = getIntent();
        usrU = (User) intQ.getSerializableExtra("User");
        if (usrU != null) {
            nExtraLives = usrU.getExtraLives();
            nPlayerNumber = usrU.getPlayerNumber();
        }
        gmG = (Game) intQ.getSerializableExtra("Game");
        if (gmG == null) {
            gmG = new Game();
            nQuestionNumber = 1;
            nStrikes = 0;
            bExtraLifeUsed = false;
            nScore = 0;
            gmG.setPlayerNumber(nPlayerNumber);
        } else {
            nQuestionNumber = (gmG.getQuestionNumber() + 1);
            nStrikes = gmG.getStrikes();
            bExtraLifeUsed = gmG.isExtraLifeUsed();
            nExtraLives = gmG.getExtraLives();
            nScore = gmG.getScore();
        }

        txtQuestion.setText("This is a sample question");
        txtQuestionValue.setText(((nQuestionNumber - nStrikes) * 10) + " Points");
        txtScore.setText("Your Score: " + nScore);
        txtTimer.setText("10");

        Random randomno = new Random();

        bCorrectAnswer = randomno.nextBoolean();

        // OnClickListener not working and playing well with CountDownTimer
        btnTrue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(QuestionActivity.this, AnswerActivity.class);
                intA.putExtra("YourAnswer", bYourAnswer);
                intA.putExtra("CorrectAnswer", bCorrectAnswer);
                intA.putExtra("User", usrU);
                intA.putExtra("Game", gmG);
                startActivity(intA);
                finish();
            }
        });

        btnFalse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intA = new Intent(QuestionActivity.this, AnswerActivity.class);
                intA.putExtra("YourAnswer", bYourAnswer);
                intA.putExtra("CorrectAnswer", bCorrectAnswer);
                intA.putExtra("User", usrU);
                intA.putExtra("Game", gmG);
                startActivity(intA);
                finish();
            }
        });

        mCountDown = new CountDownTimer(10000, 1000) {
            @Override
            public void onFinish() {
                Intent intA = new Intent(QuestionActivity.this, AnswerActivity.class);
                bYourAnswer = !bCorrectAnswer;
                intA.putExtra("YourAnswer", bYourAnswer);
                intA.putExtra("CorrectAnswer", bCorrectAnswer);
                intA.putExtra("User", usrU);
                intA.putExtra("Game", gmG);
                startActivity(intA);
                finish();
            }

            @Override
            public void onTick(long millisUntilFinished) {
                txtTimer.setText(String.valueOf(millisUntilFinished / 1000));
            }
        }.start();
    }

}
