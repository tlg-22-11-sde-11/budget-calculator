package com.financialmanagement.controller;

import com.financialmanagement.model.Budget;
import com.financialmanagement.model.BudgetComparison;
import com.financialmanagement.model.Category;
import com.financialmanagement.model.SavingsTarget;
import com.financialmanagement.model.SavingsType;
import com.financialmanagement.view.MainView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class BudgetController {

  private final Budget budget;
  private final PrintStream output;
  private final BufferedReader input;
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  double income;

  //Constructor
  public BudgetController(Budget budget, PrintStream output, BufferedReader input)
      throws IOException {
    this.budget = budget;
    this.output = output;
    this.input = input;
  }

  //Business Method
  public void initialize(Budget budget) throws IOException {
    enterUserName(budget);
    enterIncome(budget);
  }

  private void enterIncome(Budget budget) throws IOException {
    while (true) {
      System.out.print("Enter your monthly income: ");
      String input = null;
      try {
        input = reader.readLine();
        income = Double.parseDouble(input);
        budget.setIncome(income);
        break;
      } catch (IllegalArgumentException f) {
        System.out.printf("Invalid input: %s%n", input);
      }
    }
  }

  private void enterUserName(Budget budget) throws IOException {
    while (true) {
      System.out.print("Please enter your name: ");
      String userName = null;
      try {
        userName = reader.readLine();
        budget.setUserName(userName);
        break;
      } catch (IllegalArgumentException e) {
        System.out.printf("Invalid input: %s%n", userName);
      }
    }
  }

  public void requestUserExpenses(BudgetComparison comparison) throws IOException {
    for (Category category : Category.values()) {
      while (true) {
        System.out.printf("Enter your monthly expenses for %s: ", category);
        double amount = 0;
        try {
          amount = Double.parseDouble(reader.readLine());
          budget.addExpense(category, amount);
          comparison.compareEachExpense(category);
          break;
        } catch (IllegalArgumentException e) {
          System.out.format("Invalid input %s%n: ", input);
        }
      }
    }
    comparison.compareAllExpenses();
  }

  public double savingsGoal() throws IOException {
    SavingsTarget savingsTarget = new SavingsTarget();
    while (true) {
      System.out.print("Enter your savings goal amount: ");
      double savingsGoal = 0;
      try {
        savingsGoal = Double.parseDouble(reader.readLine());
        savingsTarget.setTargetAmount(savingsGoal);
        return savingsGoal;
      } catch (IllegalArgumentException e) {
        System.out.printf("Invalid input: %s%n", savingsGoal);
      }
    }
  }

  public double currentSavings(double savingsGoal) throws IOException {
    while (true) {
      System.out.print("Enter your current savings: ");
      double currentSaved = 0;
      try {
        currentSaved = Double.parseDouble(reader.readLine());
        SavingsTarget savingsTarget = new SavingsTarget(savingsGoal, currentSaved);
        savingsTarget.setCurrentSaved(currentSaved);
        savingsTarget.setRemainingAmount(savingsGoal - currentSaved);
        return currentSaved;
      } catch (IllegalArgumentException e) {
        System.out.printf("Invalid input: %s%n", currentSaved);
      }
    }
  }

  public SavingsType inputSavingsType() throws IOException {
    while (true) {
      System.out.println("Select your savings goal type: ");
      System.out.println("1. Emergency Fund");
      System.out.println("2. Vacation");
      System.out.println("3. Other");
      int choice = 0;
      try {
        choice = Integer.parseInt(reader.readLine());
        if (choice >= 1 && choice <= 3) {
          return SavingsType.values()[choice - 1];
        }
      } catch (IllegalArgumentException e) {
        System.out.printf("Invalid input: %s%n", choice);
        System.out.println("Choice must be between 1-3 ");
      }
    }
  }

  public void displays(Budget budget, BudgetComparison comparison, SavingsTarget savingsTarget) {
    MainView view = new MainView(budget, comparison, savingsTarget);
    view.displayIncome();
    view.displayExpenses();
    view.displayTotalExpenses();
    view.displaySavings();
    view.displaySavingsTarget();
  }

}









