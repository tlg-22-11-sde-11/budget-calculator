package com.financialmanagement.view;

import com.financialmanagement.model.Category;
import com.financialmanagement.model.SavingsTarget;
import java.util.Map;

public class MainView {

    public void showRemainingBudget(double remainingBudget) {
        System.out.println("Your remaining budget is: $" + remainingBudget);
    }
    public void showBudgetComparison(Map<Category, String> comparisonResult) {
        for (Map.Entry<Category, String> entry : comparisonResult.entrySet()) {
            System.out.println(entry.getKey() + " expenses are " + entry.getValue() + " than US average.");
        }
    }
    public void showSavingsTarget(SavingsTarget savingsTarget) {
        System.out.println("You've set a savings goal of $" + savingsTarget.getAmount() + " for "
            + savingsTarget.getType() + " fund, from "+ savingsTarget.getStartDate() + " to "+ savingsTarget.getDeadline() );
    }
}

