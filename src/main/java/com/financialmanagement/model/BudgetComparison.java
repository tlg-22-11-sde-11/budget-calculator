package com.financialmanagement.model;

public class BudgetComparison {

    public static final String AVG_MSG = "%n%s: The average American household spends %.2f%% of their after-tax income in this category.%n";
    public static final String COMPARE_MESSAGE = "Difference: You are spending %.2f %s  the national household average for this category.%n%n";
    private final Budget budget;
    private double categoryUSAverage;
    private double difference;
    //private double user

    public BudgetComparison(Budget budget) {
        this.budget = budget;
    }

    public double compareExpense(Category category) {
        categoryUSAverage = (budget.getIncome() * category.percentage());
        System.out.println(categoryUSAverage);
        difference = budget.getExpense(category) - categoryUSAverage;
        String operator =
            difference == 0 ? "the SAME AS" : difference > 0 ? "MORE THAN" : "LESS THAN";
        System.out.printf(AVG_MSG, category.category(), (category.percentage() * 100));
        System.out.printf(COMPARE_MESSAGE, Math.abs(difference), operator);
        return 0;
    }
}