package com.financialmanagement.model;

import java.nio.charset.IllegalCharsetNameException;
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

    public void setUserName(String userName) throws IllegalCharsetNameException {
        if(userName.isEmpty()){
            throw new IllegalCharsetNameException("You must enter a username to proceed");
        }
        //try to add code to detect any input other than char. I've seen some examples with putting the string into an array and checking each index
        this.userName = userName;
    }
    public String getUserName(){
        return userName;
    }

    public double getIncome() throws NumberFormatException {
        if(income < 0){
            throw new NumberFormatException(
                "Invalid input: Monthly income should be greater than 0. Please try again.");
        }else
        return income;
    }

    public void addExpense(Category category, double amount) throws NumberFormatException{
        if (amount < 0){
            throw new NumberFormatException(
                "The amount entered must be greater than or equal to 0"
            );
        }else
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




