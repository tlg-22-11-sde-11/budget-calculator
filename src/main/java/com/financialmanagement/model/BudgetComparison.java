package com.financialmanagement.model;

import java.util.Map;

public class BudgetComparison {

  public static final String AVG_MSG = "%n%s: The average American household spends %.2f%% of their after-tax income in this category.%n";
  public static final String COMPARE_MESSAGE = "Difference: %.2f You are spending %s the national household average for this category.%n%n";

  private double categoryExpenseAmount;
  //private double userIncomeAmount;
  private Map<Category, Double> categories;


  //BudgetComparison Ctor
  public BudgetComparison(Map<Category, Double> categories, Category category, String name) {
    Budget userBudget = new Budget("Ray");
    this.categories = categories;
  }

  double userIncomeAmount = userBudget.getIncome();

  public void compareThis(Category category) {

    categoryExpenseAmount = categories.get(category);
    double categoryAverage = (category.percentage()*userIncomeAmount);
    System.out.println(categoryAverage);
    double difference =  categoryAverage - categoryExpenseAmount;
    String operator = difference == 0 ? "the SAME AS" : difference > 0 ? "MORE THAN" : "LESS THAN";

    System.out.printf(AVG_MSG, category.category(), (category.percentage()*100));
    System.out.printf(COMPARE_MESSAGE, difference, operator);
  }
}


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
