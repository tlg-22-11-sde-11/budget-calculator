package com.financialmanagement.view;

import com.financialmanagement.model.Budget;
import com.financialmanagement.model.BudgetComparison;
import com.financialmanagement.model.Category;
import com.financialmanagement.model.SavingsTarget;
import java.util.Map;

public class MainView {

    private Budget budget;
    private BudgetComparison comparison;
    private SavingsTarget savingsTarget;
    private String DELIMITER = "===============================================================================================";


    public MainView(Budget budget, BudgetComparison comparison, SavingsTarget savingsTarget) {
        this.budget = budget;
        this.savingsTarget = savingsTarget;
        this.comparison = comparison;
    }

    public void displayIncome() {
        System.out.println("Your monthly income is: $" + budget.getIncome());
    }

    public void displayExpenses() {
        System.out.println(DELIMITER);
        System.out.printf("Your monthly expenses are:%n%n");
        for (Category category : Category.values()) {
            System.out.println("\t*" + category + ": $" + budget.getExpense(category));
        }
        System.out.println(DELIMITER);
    }

    public void displayTotalExpenses() {
        System.out.println("Your total monthly expense is $" + budget.getTotalExpenses());
        System.out.println(DELIMITER);
    }

    public void displaySavings() {
        System.out.println("Your total savings is $" + budget.getSavings());
        System.out.println(DELIMITER);
    }

    public void displaySavingsTarget() {
        System.out.println("Your savings goal is $" + savingsTarget.getTargetAmount() + " for your desired savings target.");
        System.out.println("You have saved $" + savingsTarget.getCurrentSaved()
        + " towards your goal. You still need to save $" + savingsTarget.getRemainingAmount()
        + " to reach your goal.");
        System.out.println(DELIMITER);
    }
}

