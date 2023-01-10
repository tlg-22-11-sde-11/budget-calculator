package com.financialmanagement.controller;

import com.financialmanagement.model.Budget;
import com.financialmanagement.view.MainView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class MainController {

  private final Budget budget;
  private final PrintStream output;
  private final BufferedReader input;

  public MainController(Budget budget, PrintStream output, BufferedReader input) {
    this.budget = budget;
    this.output = output;
    this.input = input;
  }
  public void run() throws IOException {
    MainView view = new MainView();
  }
  // TODO: 1/10/23 create new method with user inputs
  public static void startDialog(){
  }

  private boolean continueBudgeting() throws IOException {
    System.out.println("Please select from the menu options");
    return false;
  }
}





