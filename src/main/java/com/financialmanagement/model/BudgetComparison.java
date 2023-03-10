package com.financialmanagement.model;

public class BudgetComparison {

    public static final String AVG_MSG = "%n%s: The average American household spends %.2f%% of their income in this category.%n";
    public static final String COMPARE_MESSAGE = "Difference: You are spending %s %s the national household average for this category.%n%n";
    private static final double AVG_NATNL_SPENDING= 0.82;
    private final Budget budget;
    private double categoryUSAverage;
    private double monthlyDifference;
    private double totalDifference;
    private String DELIMITER = "===============================================================================================";

    public BudgetComparison(Budget budget) {

        this.budget =  budget;
    }

    public void compareEachExpense(Category category) {
      categoryUSAverage = (budget.getIncome()* category.percentage());
      monthlyDifference =  budget.getExpense(category) - categoryUSAverage;
      String operator = monthlyDifference == 0 ? "the SAME AS" : monthlyDifference > 0 ? "MORE THAN" : "LESS THAN";
      System.out.println(DELIMITER);
      System.out.printf(AVG_MSG, category.category(), (category.percentage()*100));
      System.out.printf(COMPARE_MESSAGE, monthlyDifference == 0 ? "" : String.valueOf(Math.abs(monthlyDifference)), operator);
      System.out.println(DELIMITER);
    }

    public void compareAllExpenses() {
      totalDifference = budget.getTotalExpenses() - (budget.getIncome()* AVG_NATNL_SPENDING);
      String operator = totalDifference == 0 ? "the SAME AS" : monthlyDifference > 0 ? "MORE THAN" : "LESS THAN";
      System.out.printf("%s: The average American household spends %.2f%% of their income in these categories.%n", "Total Expenses", AVG_NATNL_SPENDING*100);
      System.out.printf("You are spending %s %s the national household average for all expense.%n", monthlyDifference == 0 ? "" : String.valueOf(Math.abs(monthlyDifference)), operator);
      System.out.println(DELIMITER);
    }
}