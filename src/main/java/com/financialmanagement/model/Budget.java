package com.financialmanagement.model;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Budget {

  private double income;
  private Map<Category, Double> expenses = new HashMap<>();
  private String userName;

  public Budget() {
  }

  public Budget(String userName) {
    this();
    setUserName(userName);
  }

  public Budget(String userName, double income) {
    this(userName);
    this.income = income;
    this.expenses = new EnumMap<>(Category.class);
  }

  public void setUserName(String userName) throws IllegalArgumentException {

    if (userName == null || userName.isEmpty() || !userName.matches("[a-zA-Z]+")) {
      throw new IllegalArgumentException("You must enter a username to proceed");
    }
    this.userName = userName;
  }

  public String getUserName() {
    return userName;
  }

  public double getIncome() {
    return income;
  }


  public void setIncome(double income) throws IllegalArgumentException {
    if (income < 0) {
      throw new IllegalArgumentException("Income cannot be below 0");
    }
    this.income = income;
  }

  public void addExpense(Category category, double amount) throws IllegalArgumentException {
    if (amount < 0) {
      throw new IllegalArgumentException("The amount entered must be greater than or equal to 0");
    }
    expenses.put(category, amount);
  }

  public double getExpense(Category category) {
    return expenses.getOrDefault(category, 0.0);
  }

  public double getTotalExpenses() {
    return expenses.values().stream().mapToDouble(Double::doubleValue).sum();
  }

  public double getSavings() {
    return income - getTotalExpenses();
  }
}




