package com.financialmanagement.controller;

import com.financialmanagement.model.Budget;
import com.financialmanagement.view.MainView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MainController {

//  private final Budget budget;
//  private final PrintStream output;
//  private final BufferedReader input;

  public MainController() {
//    this.budget = budget;
//    this.output = output;
//    this.input = input;
  }

  public void run() throws IOException {
    startDialog();
  }

  public static void startDialog() throws IOException {
    MainView view = new MainView();
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Please enter your name: ");
    String name = input.readLine();
    System.out.format("Welcome %s! Please enter your income: ", name);
    double income = Double.parseDouble(input.readLine());
    System.out.format("Enter your expenses to see a breakdown of your monthly income of %s.", income);
    view.showRemainingBudget(income);

  }
  // TODO: validations

  private boolean continueBudgeting() throws IOException {
    System.out.println("Please select from the menu options");
    return false;
  }
}





