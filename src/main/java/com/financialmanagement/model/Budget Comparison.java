package com.financialmanagement.model;

public abstract class BudgetComparison {
  //This class may need a calculator class function
  //Budget class has fake data for sake of creating functional code but will be deleted

  //According to 2020 Consumer Expenditure Survey conducted by the U.S. Bureau of Labor Statistics.
  public static final int AVG_SPENDING_PRCNT = 82;
  public static final int AVG_HOUSING_PRCNT = 15;
  public static final int AVG_TRANSPORT_PRCNT = 12;
  public static final int AVG_UTIL_PRCNT = 10;
  public static final int AVG_FOOD_PRCNT = 9;
  public static final int AVG_ENTERTAIN_PRCNT = 3;
  public static final String AVG_MSG = "%s: The average American household spends %.2f%% of their after-tax income in this category.%n";
  public static final String COMPARE_MESSAGE = "Difference: %.2f You are spending %s the national household average for this category.%n";

  double matchSpendingPercentage;

  //BudgetComparison Ctor
  public BudgetComparison(Category category,
      String name) { // TODO: 1/10/2023 add a Category for ALL?
    Budget userBudget = new Budget(name);
    userBudget.getCategories(userBudget.getCategoryAmount(
        category)); // TODO: 1/10/2023 public Map<Category, Double> getCategories(double categoryAmount)
    matchSpendingPercentage = userBudget.getTotal() * AVG_SPENDING_PRCNT;
  }

  void compareThis(String category) {
  }
}

public class compareSpending extends BudgetComparison {

  public compareSpending(Category category, String name) {
    super(category, name);
  }

  @Override
  public void compareThis(String category) {
    double difference = matchSpendingPercentage - budget.totalSpending;
    String operator = difference == 0 ? "the SAME AS" : difference > 0 ? "MORE THAN" : "LESS THAN";
    System.out.printf(AVG_MSG, category, AVG_SPENDING_PRCNT);
    System.out.printf(COMPARE_MESSAGE, difference, operator);
  }
}

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
