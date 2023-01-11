package com.financialmanagement.controller;

import com.financialmanagement.model.Budget;
import com.financialmanagement.model.Category;
import com.financialmanagement.view.MainView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Map;

public class MainController {

//  private final Budget budget;
//  private final PrintStream output;
//  private final BufferedReader input;

  private Map<Category, Double> categories;

  public MainController() {
//    this.budget = budget;
//    this.output = output;
//    this.input = input;
  }

  public void run() throws IOException {
    startDialog();
  }

  public void startDialog() throws IOException {
    MainView view = new MainView();
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

o

    /*
    for (Category category : Category.values()) {
      System.out.format("What is your estimated monthly %s expense? : ", Category.values());
      double expense = Double.parseDouble(input.readLine());
      categories.put(Category, expense);
    }*/

    for (Category category : Category.values()) {
      System.out.format("What is your estimated monthly %s expense? : ", Category.values());
      double amount = Double.parseDouble(input.readLine());
      budget.addCategory(category, amount); }


    budget.setCategories(categories);

    //for each category in map
    view.showRemainingBudget(budget.getIncome());
    //doBudget();
    //doBudgetComparison();


  }
  // TODO: validations

  private boolean continueBudgeting() throws IOException {
    System.out.println("Please select from the menu options");
    return false;
  }

  private void doBudget() {

  }
}




