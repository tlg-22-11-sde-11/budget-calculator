package com.financialmanagement.model;

import java.util.Map;

public class BudgetComparison {

    public static final String AVG_MSG = "%n%s: The average American household spends %.2f%% of their after-tax income in this category.%n";
    public static final String COMPARE_MESSAGE = "Difference: You are spending %.2f %s  the national household average for this category.%n%n";
    private final Budget budget;
    private double categoryUSAverage;
    private double difference;
    //private double user

    public BudgetComparison(Budget budget) {
        this.budget =  budget;
    }

    public void compareExpense(Category category) {
      categoryUSAverage = (budget.getIncome()* category.percentage());
      System.out.println(categoryUSAverage);
      difference =  budget.getExpense(category) - categoryUSAverage;
      String operator = difference == 0 ? "the SAME AS" : difference > 0 ? "MORE THAN" : "LESS THAN";
      System.out.printf(AVG_MSG, category.category(), (category.percentage()*100));
      System.out.printf(COMPARE_MESSAGE, Math.abs(difference),  operator);
    }

    //public void compareAllExpenses() {


    //}
}

//
//
//  private double categoryExpenseAmount;
//  private double userIncomeAmount;
//  double difference;
//  double categoryAverage;
//
//  private Map<Category, Double> categories;
//

//  //BudgetComparison Ctor
//  public BudgetComparison(Map<Category, Double> categories, Category comparingCategory, String userName) {
//    //this.categories = categories;
//    Budget userBudget = new Budget(userName);
//    userIncomeAmount = userBudget.getIncome();
//    categoryExpenseAmount = categories.get(comparingCategory);
//  }

//  public void compareThis(Category category) {
//
//    categoryAverage = (category.percentage()*userIncomeAmount);
//    System.out.println(categoryAverage);
//    difference =  categoryAverage - categoryExpenseAmount;
//    String operator = difference == 0 ? "the SAME AS" : difference > 0 ? "MORE THAN" : "LESS THAN";
//
//    System.out.printf(AVG_MSG, category.category(), (category.percentage()*100));
//    System.out.printf(COMPARE_MESSAGE, difference, operator);
//  }
//}


/*co
class compareHousing extends BudgetComparison {

  @Override
  public void compareThis() {

  }
}

class compareTransport extends BudgetComparison {

  @Override
  public void compareThis() {

  }
}

class compareUtilities extends BudgetComparison {

  @Override
  public void compareThis() {

  }
}

class compareFood extends BudgetComparison {

  @Override
  public void compareThis() {

  }
}

class compareEntertainment extends BudgetComparison {

  @Override
  public void compareThis() {

  }
}

class allComparison extends BudgetComparison {

  @Override
  public void compareThis() {

  }
}

//Constructor
 /* public CompareBudget(String request){
    //int userIncome = budget.monthlyIncome;
    //int userSpending = budget.monthlySpending;
    CompareFactory factory = new CompareFactory();
  }*/
/*
  public compareThis() {   //used to compare across all 6 categories
    public CompareBudget compareCategory (String request){
      //change to switch?

      CompareBudget(String request)

      if ("SPENDING".equals(request)) {

      } else if ("HOUSING".equals(request)) {

      } else if ("TRANSPORT".equals(request)) {

      } else if ("UTILITIES".equals(request)) {

      } else if ("FOOD".equals(request)) {

      } else if ("ENTERTAINMENT".equals(request)) {

      } else if ("ALL".equals(request)) {

      }
      return
    }
  }
*/
// TODO: 1/9/2023 comparator with percentages

// TODO: 1/9/23 pull data from US census for average income, average shelter costs (rent/mortgage), average savings
// TODO: 1/9/23 Compare user's input from UserData and display it in CompareBudgetView in comparison to average
