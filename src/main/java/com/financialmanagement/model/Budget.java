package com.financialmanagement.model;

import java.util.EnumMap;
import java.util.Map;

public class Budget {
    private double income;
    private Map<Category, Double> expenses;
    private String userName;

    public Budget(double income, String userName) {
        this.income = income;
        this.expenses = new EnumMap<>(Category.class);
        this.userName = userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return userName;
    }

    public double getIncome() {
        return income;
    }

    public void addExpense(Category category, double amount) {
        expenses.put(category, amount);
    }

    public double getExpense(Category category) {
        return expenses.getOrDefault(category, 0.0);
    }

    public double getTotalExpenses() {
        return expenses.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public double getSavings() {
        return income - getTotalExpenses();
    }
}




