package com.financialmanagement.model;

public class SavingsTarget {

    public String getRemainingToSave;
    public String remaingToSave;
    private double remainingAmount;
    private double targetAmount;
    private SavingsType savingsType;
    private double currentSaved;

    public SavingsTarget(double targetAmount, SavingsType savingsType, double currentSaved) {
        this.targetAmount = targetAmount;
        this.savingsType = savingsType;
        this.currentSaved = currentSaved;
    }

    public double getRemainingAmount() {
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

    public void setCurrentSaved(double currentSaved) {
        this.currentSaved = currentSaved;
    }

    public double remaingToSave(double v) {
        return 0;
    }
}

