package com.danielburgnerjr.goodforcedemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.danielburgnerjr.goodforcedemo.model.Game;
import com.danielburgnerjr.goodforcedemo.model.User;

public class AnswerActivity extends Activity {
    Intent intQ;
    private User usrU;
    private Game gmG;

    TextView txtAnswerOutcome;
    TextView txtAnswerExplanation;
    TextView txtScoreAnswer;
    TextView txtNumStrikes;
    boolean bYourAnswer;
    boolean bCorrectAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        txtAnswerOutcome = findViewById(R.id.txtAnswerOutcome);
        txtAnswerExplanation = findViewById(R.id.txtAnswerExplanation);
        txtScoreAnswer = findViewById(R.id.txtScoreAnswer);
        txtNumStrikes = findViewById(R.id.txtNumStrikes);

        final Button btnContinue = findViewById(R.id.btnContinue);

        intQ = getIntent();
        usrU = (User) intQ.getSerializableExtra("User");
        gmG = (Game) intQ.getSerializableExtra("Game");
        bYourAnswer = intQ.getBooleanExtra("YourAnswer", false);
        bCorrectAnswer = intQ.getBooleanExtra("CorrectAnswer", false);
        String strOutcome = "";
        String strExplanation = "This is why your answer is right or wrong.";
        if (bYourAnswer == bCorrectAnswer) {
            strOutcome += "Correct!";
            gmG.setScore(gmG.getScore() + gmG.getQuestionValue());
            gmG.setStreak(gmG.getStreak() + 1);
            if (gmG.getStreak() == 10) {
                usrU.setExtraLives(usrU.getExtraLives() + 1);
                AlertDialog adAlertBox = new AlertDialog.Builder(this).create();
                adAlertBox.setMessage("You earned an extra life for answering ten questions in a row correctly!");
                adAlertBox.setButton(AlertDialog.BUTTON_POSITIVE, "OK", (DialogInterface arg0, int arg1) -> {
                });
                adAlertBox.show();
            }
        } else {
            strOutcome += "Wrong!";
            gmG.setStrikes(gmG.getStrikes() + 1);
            gmG.setStreak(0);
        }
        if ((gmG.getStrikes() == 3) && (gmG.getExtraLives() == 0)) {
            gmG.setExtraLifeUsed(true);
        }
        txtAnswerOutcome.setText(strOutcome);
        txtAnswerExplanation.setText(strExplanation);
        String strScore = "Your Score: " + gmG.getScore();
        String strStrikes = "Strikes: " + gmG.getStrikes();
        txtScoreAnswer.setText(strScore);
        txtNumStrikes.setText(strStrikes);
        gmG.setQuestionNumber(gmG.getQuestionNumber() + 1);

        btnContinue.setOnClickListener((View view) -> {
            if ((gmG.getStrikes() < 3) || (!gmG.isExtraLifeUsed())) {
                Intent intA = new Intent(AnswerActivity.this, QuestionActivity.class);
                intA.putExtra("User", usrU);
                intA.putExtra("Game", gmG);
                startActivity(intA);
                finish();
            } else {
                Intent intA = new Intent(AnswerActivity.this, WatchVideoActivity.class);
                intA.putExtra("User", usrU);
                intA.putExtra("Game", gmG);
                startActivity(intA);
                finish();
            }
        });
    }
}
