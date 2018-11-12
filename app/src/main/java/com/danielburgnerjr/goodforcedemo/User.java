package com.danielburgnerjr.goodforcedemo;

public class User {
    private String strFirstName;
    private String strLastName;
    private String strEmailAddress;
    private String strPassword;
    private int nExtraLives;
    private int nCoins;
    private int nGFPoints;
    private int nPlayerNumber;
    private String strGoodForceCode;
    private String strZipCode;

    public void setFirstName(String strFN) {
        this.strFirstName = strFN;
    }

    public String getFirstName() {
        return this.strFirstName;
    }

    public void setLastName(String strLN) {
        this.strLastName = strLN;
    }

    public String getLastName() {
        return this.strLastName;
    }

    public void setEmailAddress(String strEA) {
        this.strEmailAddress = strEA;
    }

    public String getEmailAddress() {
        return this.strEmailAddress;
    }

    public void setPassword(String strPW) {
        this.strPassword = strPW;
    }

    public String getPassword() {
        return this.strPassword;
    }

    public void setExtraLives(int nEL) {
        this.nExtraLives = nEL;
    }

    public int getExtraLives() {
        return this.nExtraLives;
    }

    public void setCoins(int nC) {
        this.nCoins = nC;
    }

    public int getCoins() {
        return this.nCoins;
    }

    public void setGFPoints(int nGFP) {
        this.nGFPoints = nGFP;
    }

    public int getGFPoints() {
        return this.nGFPoints;
    }

    public void setPlayerNumber(int nPN) {
        this.nPlayerNumber = nPN;
    }

    public int getPlayerNumber() {
        return this.nPlayerNumber;
    }

    public void setGoodForceCode(String strGFC) {
        this.strGoodForceCode = strGFC;
    }

    public String getGoodForceCode() {
        return this.strGoodForceCode;
    }

    public void setZipCode(String strZIP) {
        this.strZipCode = strZIP;
    }

    public String getZipCode() {
        return this.strZipCode;
    }

}
