package com.financialmanagement.model;

import java.nio.charset.IllegalCharsetNameException;
import java.util.EnumMap;
import java.util.Map;

public class Budget {

  private double income;
  private Map<Category, Double> expenses;
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

    if (userName.isEmpty() || userName == null || !userName.matches("[a-zA-Z]+")) {
      throw new IllegalArgumentException("You must enter a username to proceed");

    } else {
      this.userName = userName;

    }
  }



  public String getUserName() {
    return userName;
  }

  public double getIncome() throws NumberFormatException {
    if (income < 0) {
      throw new NumberFormatException(
          "Invalid input: Monthly income should be greater than 0. Please try again.");
    } else {
      return income;
    }
  }

  public void addExpense(Category category, double amount) throws NumberFormatException {
    if (amount < 0) {
      throw new NumberFormatException(
          "The amount entered must be greater than or equal to 0"
      );
    } else {
      expenses.put(category, amount);
    }
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




