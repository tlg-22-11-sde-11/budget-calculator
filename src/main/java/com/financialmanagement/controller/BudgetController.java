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
  public void initialize() throws IOException {
    do {
      System.out.print("Please enter your name: ");
      String userName;
      Budget budget = new Budget();
      try {
        userName = reader.readLine();
        budget.setUserName(userName);

      } catch (IOException e) {
        System.out.println("Invalid input");
      }

      while (true) {
        System.out.print("Enter your monthly income: ");
        String input = reader.readLine();
        try {
          income = Double.parseDouble(input);
          if (income > 0) {
            //Budget budget = new Budget(userName, income);
            break;
          } else {
            System.out.println(
                "Invalid input: Monthly income should be greater than 0. Please try again.");
          }
        } catch (NumberFormatException f) {
          System.out.println("Invalid input: Pleaser enter a valid number.");
        }
      }
    } while (true);
  }

  public void requestUserExpenses(BudgetComparison comparison) throws IOException {

    for (Category category : Category.values()) {
      double amount;
      while (true) {
        System.out.print("Enter your monthly expenses for " + category + ": ");
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
        } catch (NumberFormatException f) {
          System.out.println("Invalid input: Please enter a valid number.");
        }
      }
    }
    comparison.compareAllExpenses();
  }


  public void savingsMethod() throws IOException {
    double savingsGoal = 0;
    while (true) {
      System.out.print("Enter your savings goal amount: ");
      String input = reader.readLine();
      try {
        savingsGoal = Double.parseDouble(input);
        //move this
        if (savingsGoal > 0) {
          break;
        } else {
          System.out.println(
              "Invalid input: Savings goal amount should be greater than 0. Please try again.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input: Please enter a valid number.");
      }

      SavingsType savingsType = inputSavingsType("Select your savings goal type: ", reader);

      double currentSaved = 0;
      while (true) {
        System.out.print("Enter your current savings: ");
        input = reader.readLine();
        try {
          currentSaved = Double.parseDouble(input);
          if (currentSaved > 0) {
            break;
          } else {
            System.out.println(
                "Invalid input: Current savings should be greater than or equal to 0.");
          }
        } catch (NumberFormatException x) {
          System.out.println("Invalid input: Pleaser enter a valid number.");
        }
      }

      SavingsTarget savingsTarget = new SavingsTarget(savingsGoal, savingsType, currentSaved);
      savingsTarget.setRemainingAmount(savingsGoal - currentSaved);
    }
  }

  public static SavingsType inputSavingsType(String message, BufferedReader reader) {
    while (true) {
      try {
        System.out.println(message);
        System.out.println("1. Emergency Fund");
        System.out.println("2. Vacation");
        System.out.println("3. Other");
        int choice = Integer.parseInt(reader.readLine());
        if (choice >= 1 && choice <= 3) {
          return SavingsType.values()[choice - 1];
        } else {
          System.out.println("Invalid input. Please select a valid option.");
        }
      } catch (NumberFormatException | IOException e) {
        System.out.println("Invalid input. Please enter a valid number.");
      }
    }
  }

  public void displays(Budget budget, BudgetComparison comparison, SavingsTarget savingsTarget) {
    MainView view = new MainView(budget, comparison, savingsTarget);
    view.displayIncome();
    view.displayExpenses();
    view.displaySavings();
    view.displaySavingsTarget();
  }

}









