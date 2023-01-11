package com.financialmanagement.model;

public class BudgetComparison {

    public static final String AVG_MSG = "%n%s: The average American household spends %.2f%% of their after-tax income in this category.%n";
    public static final String COMPARE_MESSAGE = "Difference: You are spending %.2f %s the national household average for this category.%n%n";
    private static final double AVG_NATNL_SPENDING= 0.82;
    private final Budget budget;
    private double categoryUSAverage;
    private double monthlyDifference;
    private double totalDifference;

    public BudgetComparison(Budget budget) {

        this.budget =  budget;
    }

    public void compareEachExpense(Category category) {
      categoryUSAverage = (budget.getIncome()* category.percentage());
      monthlyDifference =  budget.getExpense(category) - categoryUSAverage;
      String operator = monthlyDifference == 0 ? "the SAME AS" : monthlyDifference > 0 ? "MORE THAN" : "LESS THAN";
      System.out.printf(AVG_MSG, category.category(), (category.percentage()*100));
      System.out.printf(COMPARE_MESSAGE, Math.abs(monthlyDifference), operator);
    }

    public void compareAllExpenses() {
      totalDifference = budget.getTotalExpenses() - (budget.getIncome()* AVG_NATNL_SPENDING);
      String operator = totalDifference == 0 ? "the SAME AS" : monthlyDifference > 0 ? "MORE THAN" : "LESS THAN";
      System.out.printf(AVG_MSG, "Total Expenses", AVG_NATNL_SPENDING*100);
      System.out.printf(COMPARE_MESSAGE, Math.abs(monthlyDifference), operator);

    }
}