package com.danielburgnerjr.goodforcedemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.danielburgnerjr.goodforcedemo.model.Game;
import com.danielburgnerjr.goodforcedemo.model.User;

import java.util.Random;

public class QuestionActivity extends Activity {

    TextView txtQuestion;
    TextView txtQuestionValue;
    TextView txtScore;
    private TextView txtTimer;
    Button btnTrue;
    Button btnFalse;
    private boolean bCorrectAnswer;
    private boolean bYourAnswer;
    int nStrikes;
    int nQuestionNumber;
    int nQuestionValue;
    private int nPlayerNumber;
    int nExtraLives;
    boolean bExtraLifeUsed;
    int nScore;
    private CountDownTimer mCountDown;
    Intent intQ;
    private User usrU;
    private Game gmG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        txtQuestion = findViewById(R.id.txtQuestion);
        txtQuestionValue = findViewById(R.id.txtQuestionValue);
        txtScore = findViewById(R.id.txtScore);
        txtTimer = findViewById(R.id.txtTimer);
        btnTrue = findViewById(R.id.btnTrue);
        btnFalse = findViewById(R.id.btnFalse);

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
            nQuestionValue = 10;
            bExtraLifeUsed = false;
            nScore = 0;
            gmG.setQuestionNumber(nQuestionNumber);
            gmG.setStrikes(nStrikes);
            gmG.setScore(nScore);
            gmG.setStreak(0);
            gmG.setQuestionValue(nQuestionValue);
            gmG.setPlayerNumber(nPlayerNumber);
            gmG.setExtraLives(usrU.getExtraLives());
            gmG.setMaxStrikes(gmG.getExtraLives());
            gmG.setExtraLifeUsed(bExtraLifeUsed);
        } else {
            nQuestionNumber = (gmG.getQuestionNumber());
            nStrikes = gmG.getStrikes();
            nQuestionValue = (nQuestionNumber - nStrikes) * 10;
            gmG.setQuestionValue(nQuestionValue);
            bExtraLifeUsed = gmG.isExtraLifeUsed();
            nExtraLives = gmG.getExtraLives();
            if (nExtraLives == usrU.getExtraLives()) {
                usrU.setExtraLives(nExtraLives);
            }
            nScore = gmG.getScore();
        }
        if ((gmG.getStrikes() == 3) && (gmG.getExtraLives() > 0)) {
            if (!gmG.isExtraLifeUsed()) {
                AlertDialog adAlertBox = new AlertDialog.Builder(this).create();
                adAlertBox.setMessage("You used an extra life for getting three strikes!");
                adAlertBox.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg0, int arg1) {
                            }
                        });
                adAlertBox.show();
                gmG.setExtraLives(gmG.getExtraLives() - 1);
                usrU.setExtraLives(usrU.getExtraLives() - 1);
                gmG.setExtraLifeUsed(true);
            }
        }

        txtQuestion.setText("This is a sample question.");
        txtQuestionValue.setText(nQuestionValue + " Points");
        txtScore.setText("Your Score: " + nScore);
        txtTimer.setText("10");

        Random randomno = new Random();

        bCorrectAnswer = randomno.nextBoolean();

        // OnClickListener not working and playing well with CountDownTimer
        btnTrue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mCountDown.cancel();
                bYourAnswer = true;
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
                mCountDown.cancel();
                Intent intA = new Intent(QuestionActivity.this, AnswerActivity.class);
                bYourAnswer = false;
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
