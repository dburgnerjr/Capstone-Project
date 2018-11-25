package com.danielburgnerjr.goodforcedemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnswerActivity extends Activity {
    private Intent intQ;
    private User usrU;
    private Game gmG;

    private TextView txtAnswerOutcome;
    private TextView txtAnswerExplanation;
    private TextView txtScoreAnswer;
    private TextView txtNumStrikes;
    private boolean bYourAnswer;
    private boolean bCorrectAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        txtAnswerOutcome = (TextView) findViewById(R.id.txtAnswerOutcome);
        txtAnswerExplanation = (TextView) findViewById(R.id.txtAnswerExplanation);
        txtScoreAnswer = (TextView) findViewById(R.id.txtScoreAnswer);
        txtNumStrikes = (TextView) findViewById(R.id.txtNumStrikes);

        final Button btnContinue = (Button) findViewById(R.id.btnContinue);

        intQ = getIntent();
        usrU = (User) intQ.getSerializableExtra("User");
        gmG = (Game) intQ.getSerializableExtra("Game");
        bYourAnswer = intQ.getBooleanExtra("YourAnswer", false);
        bCorrectAnswer = intQ.getBooleanExtra("CorrectAnswer", false);
        if (bYourAnswer == bCorrectAnswer) {
            txtAnswerOutcome.setText("Correct!");
            txtAnswerExplanation.setText("This is why your answer is correct.");
            gmG.setScore(gmG.getScore() + gmG.getQuestionValue());
            gmG.setStreak(gmG.getStreak() + 1);
            if (gmG.getStreak() == 10) {
                usrU.setExtraLives(usrU.getExtraLives() + 1);
                AlertDialog adAlertBox = new AlertDialog.Builder(this)
                        .setMessage("You earned an extra life for answering ten questions" +
                                " in a row correctly!")
                        .setPositiveButton("OK", null)
                        .show();
            }
        } else {
            txtAnswerOutcome.setText("Wrong!");
            txtAnswerExplanation.setText("This is why your answer is wrong.");
            gmG.setStrikes(gmG.getStrikes() + 1);
            gmG.setStreak(0);
        }
        if ((gmG.getStrikes() == 3) && (gmG.getExtraLives() == 0)) {
            gmG.setExtraLifeUsed(true);
        }
        txtScoreAnswer.setText("Your Score: " + gmG.getScore());
        txtNumStrikes.setText("Strikes: " + gmG.getStrikes());
        gmG.setQuestionNumber(gmG.getQuestionNumber() + 1);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if ((gmG.getStrikes() < 3) || (gmG.isExtraLifeUsed() == false)) {
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
                //Toast.makeText(getApplicationContext(), "How To Play", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
