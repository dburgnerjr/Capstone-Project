package com.danielburgnerjr.goodforcedemo;

import java.io.Serializable;

public class Game implements Serializable {
    private int nPlayerNumber;
    private int nQuestionNumber;
    private int nScore;
    private int nStrikes;
    private int nExtraLives;
    private boolean bExtraLifeUsed;

    public void setPlayerNumber(int nPN) {
        this.nPlayerNumber = nPN;
    }

    public int getPlayerNumber() {
        return this.nPlayerNumber;
    }

    public void setQuestionNumber(int nQN) {
        this.nQuestionNumber = nQN;
    }

    public int getQuestionNumber() {
        return this.nQuestionNumber;
    }

    public int getScore() {
        return this.nScore;
    }

    public void setScore(int nSc) {
        this.nScore = nSc;
    }

    public int getStrikes() {
        return this.nStrikes;
    }

    public void setStrikes(int nSt) {
        this.nStrikes = nSt;
    }

    public int getExtraLives() {
        return this.nExtraLives;
    }

    public void setExtraLives(int nEL) {
        this.nExtraLives = nEL;
    }

    public boolean isExtraLifeUsed() {
        return this.bExtraLifeUsed;
    }

    public void setExtraLifeUsed(boolean bEL) {
        this.bExtraLifeUsed = bEL;
    }

}
