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

    public MainView(Budget budget, SavingsTarget savingsTarget) {
        this.budget = budget;
        this.savingsTarget = savingsTarget;
    }

    public void displayIncome() {
        System.out.println("Your monthly income is: $" + budget.getIncome());
    }

    public void displayExpenses() {
        System.out.println("Your monthly expenses are:");
        for (Category category : Category.values()) {
            System.out.println("\t" + category + ": $" + budget.getTotalExpenses());
        }
    }

    // display comaparison
//    public void displayExpensesComparedToUSAverage() {
//        for (Category category : Category.values()) {
//            double ratio = comparison.compareExpense(category);
//            System.out.printf("Your %s expenses are %.2f% of the US average%n", category, ratio * 100);
//        }
//    }

    public void displaySavings() {
        System.out.println("Your total savings is: $" + budget.getSavings());
    }

    public void displaySavingsTarget() {
        System.out.println("Your savings goal is: $" + savingsTarget.getTargetAmount() + " for "
        + savingsTarget.getSavingsType());
        System.out.println("You have saved $" + savingsTarget.getCurrentSaved()
        + " towards your goal. You still need to save $" + savingsTarget.remaingToSave(savingsTarget.getTargetAmount() - savingsTarget.getCurrentSaved())
        + " to reach your goal.");
    }

}

