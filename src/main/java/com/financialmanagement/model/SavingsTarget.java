package com.financialmanagement.model;

public class SavingsTarget {

  private double targetAmount;
  private SavingsType savingsType;
  private double currentSaved;

  public SavingsTarget() {
  }

  public SavingsTarget(double targetAmount, double currentSaved) {
    this();
    this.targetAmount = targetAmount;
    this.currentSaved = currentSaved;
  }

  public double getRemainingAmount() {
    return targetAmount - currentSaved;
  }

  public void setRemainingAmount(double remainingAmount) {
  }

  public double getTargetAmount() {
    return targetAmount;
  }

  public void setTargetAmount(double targetAmount) throws IllegalArgumentException {
    if (targetAmount < 0) {
      throw new IllegalArgumentException("Savings Goal cannot be below 0");
    }
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

  public void setCurrentSaved(double currentSaved) throws IllegalArgumentException {
    if (currentSaved < 0) {
      throw new IllegalArgumentException("Income cannot be below 0");
    }
    this.currentSaved = currentSaved;
  }

}

