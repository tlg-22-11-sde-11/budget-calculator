package com.financialmanagement.model;

public class SavingsTarget {

    private double remainingAmount;
    private double targetAmount;
    private SavingsType savingsType;
    private double currentSaved;

    public SavingsTarget(double targetAmount, SavingsType savingsType, double currentSaved) {
        this.targetAmount = targetAmount;
        this.savingsType = savingsType;
        this.currentSaved = currentSaved;
        this.remainingAmount = targetAmount - currentSaved;
    }

    public double getRemainingAmount(){
        return targetAmount - currentSaved;
    }

    public void setRemainingAmount(double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public SavingsType getSavingsType() {
        return savingsType;
    }

    public void setSavingsType(SavingsType savingsType) {
        this.savingsType = savingsType;
    }

    public double getCurrentSaved() {
        return currentSaved;
    }

    public void setCurrentSaved(double currentSaved) throws NumberFormatException{
        if(currentSaved < 0){
            throw new NumberFormatException("The input is invalid. Your current savings should be greater than or equal to 0");
        }else
        this.currentSaved = currentSaved;
    }

}

