package com.financialmanagement.controller;

import com.financialmanagement.model.Budget;
import com.financialmanagement.model.BudgetComparison;
import com.financialmanagement.model.SavingsTarget;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class SessionController {

  private final PrintStream output;
  private final BufferedReader input;

  public SessionController(PrintStream output, BufferedReader input) {
    this.output = output;
    this.input = input;
  }

  public void run() throws IOException {
    Budget budget = new Budget();
    BudgetComparison comparison = new BudgetComparison(budget);


    do {
      BudgetController controller = new BudgetController(budget, output, input);
      controller.initialize();
      controller.requestUserExpenses(comparison);
      controller.savingsMethod();
      controller.displays(budget, comparison, savingsTarget);

    } while (continueBudgeting());
  }

  private boolean continueBudgeting() throws IOException {

    while (true) {
      System.out.println("Do you want to do you budget again? (Y/n) ");
      String input = this.input.readLine().strip().toLowerCase();
      return input.isEmpty() || (input.charAt(0) != 'n');
    }
  }
}
