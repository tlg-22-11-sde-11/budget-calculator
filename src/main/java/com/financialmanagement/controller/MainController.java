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

public class MainController {

  public static void main(String[] args) {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String userName = "";
    try {
      System.out.println("Please enter your name: ");
      userName = reader.readLine();
      double income;
      //Budget budget = null;
      while (true) {
        System.out.println("Enter your monthly income: ");
        String input = reader.readLine();
        try {
          income = Double.parseDouble(input);
          if (income > 0) {
            Budget budget = new Budget(income, userName);
            break;
          } else {
            System.out.println(
                "Invalid input: Monthly income should be greater than 0. Please try again.");
          }
        } catch (NumberFormatException e) {
          System.out.println("Invalid input: Pleaser enter a valid number.");
        }
      }
      Budget budget = new Budget(income, userName);
      BudgetComparison comparison = new BudgetComparison(budget);

      for (Category category : Category.values()) {
        double amount;
        while (true) {
          System.out.println("Enter your monthly expenses for " + category + ": ");
          String input = reader.readLine();
          try {
            amount = Double.parseDouble(input);
            if (amount > 0) {
              budget.addExpense(category,
                  amount); //let addExpense check validation throw the exception
              // TODO: 1/11/2023 keep track of total expenses so the running total doesn't exceed the income amount!
              comparison.compareEachExpense(category);
              break;
            } else {
              System.out.println(
                  "Invalid input: Expense should be greater than 0. Please try again.");
            }
          } catch (NumberFormatException e) {
            System.out.println("Invalid input: Please enter a valid number.");
          }
        }
      }

      comparison.compareAllExpenses();

      double targetAmount = 0;
      while (true) {
        System.out.println("Enter your savings goal amount: ");
        String input = reader.readLine();
        try {
          targetAmount = Double.parseDouble(input);
          if (targetAmount > 0) {
            break;
          } else {
            System.out.println(
                "Invalid input: Savings goal amount should be greater than 0. Please try again.");
          }
        } catch (NumberFormatException e) {
          System.out.println("Invalid input: Please enter a valid number.");
        }
      }

      SavingsType savingsType = inputSavingsType("Select your savings goal type: ", reader);

      double currentSaved = 0;
      while (true) {
        System.out.println("Enter your current savings: ");
        String input = reader.readLine();
        try {
          currentSaved = Double.parseDouble(input);
          if (currentSaved > 0) {
            break;
          } else {
            System.out.println(
                "Invalid input: Current savings should be greater than or equal to 0.");
          }
        } catch (NumberFormatException e) {
          System.out.println("Invalid input: Pleaser enter a valid number.");
        }
      }

      SavingsTarget savingsTarget = new SavingsTarget(targetAmount, savingsType, currentSaved);
      savingsTarget.setRemainingAmount(targetAmount - currentSaved);

      MainView view = new MainView(budget, savingsTarget);
      view.displayIncome();
      view.displayExpenses();
      view.displaySavings();
      view.displaySavingsTarget();
      //view.displayExpensesComparedToUSAverage();

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static SavingsType inputSavingsType(String message, BufferedReader reader) {
    while (true) {
      try {
        System.out.println(message);
        System.out.println("1. Short-Term");
        System.out.println("2. Medium-Term");
        System.out.println("3. Long-Term");
        int choice = Integer.parseInt(reader.readLine());
        if (choice >= 1 && choice <= 3) {
          return SavingsType.values()[choice - 1];
        } else {
          System.out.println("Invalid input. Please select a valid option.");
        }
      } catch (NumberFormatException | IOException e) {
        System.out.println("Invalid input. Please enter a valid number.");
        ;
      }
    }
  }

}






