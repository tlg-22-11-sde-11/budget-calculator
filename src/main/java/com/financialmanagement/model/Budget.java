package com.financialmanagement.model;

import java.util.EnumMap;
import java.util.Map;

public class Budget {

    private String name;
    private double total;
    private double income;
    private Map<Category, Double> categories;
    private SavingsTarget savingsTarget;

    public Budget(String name) {
        this.name = name;
        this.categories = new EnumMap<>(Category.class);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIncome() {
        return this.income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public Map<Category, Double> getCategories() {
        return this.categories;
    }

    public void setCategories(Map<Category, Double> categories) {
        this.categories = categories;
    }

    public SavingsTarget getSavingsTarget() {
        return this.savingsTarget;
    }

    public void setSavingsTarget(SavingsTarget savingsTarget) {
        this.savingsTarget = savingsTarget;
    }

    public void addCategory(Category category, double amount) {
        this.categories.put(category, amount);
    }

    public double getCategoryAmount(Category category) {
        return this.categories.get(category);
    }

    public double getSavingsTargetAmount(SavingsTarget savingsTarget) {
        // Calculate the amount allocated to the savings target by subtracting the amounts allocated to each category from the total budget amount
        double amount = this.getTotal();
        for (double categoryAmount : this.getCategories().values()) {
            amount -= categoryAmount;
        }
        return amount;
    }

    public double getRemainingBudget() {
        // Calculate the remaining budget by subtracting the amounts allocated to each category from the total budget amount
        double remainingBudget = this.getTotal();
        for (Category category : this.getCategories().keySet()) {
            remainingBudget -= this.getCategoryAmount(category);
        }
        return remainingBudget;
    }

}



