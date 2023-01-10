package com.financialmanagement.model;

import java.time.LocalDate;
import java.util.Date;

public class SavingsTarget {

    private String name;
    private double amount;
    private Date startDate;
    private Date deadline;
    private SavingsType type;
    private Budget budget; // Add a budget field to the SavingsTarget class

    public SavingsTarget(String name, double amount, Date deadline, SavingsType type) {
        this.name = name;
        this.amount = amount;
        this.deadline = deadline;
        this.type = type;
        this.budget = budget;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate() {
    }

    public Date getDeadline() {
        return this.deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public SavingsType getType() {
        return this.type;
    }

    public void setType(SavingsType type) {
        this.type = type;
    }

    public Budget getBudget() {
        return this.budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public double getAmountRemaining() {
        return this.amount - getAmountSaved();
    }

    public double getAmountSaved() {
        // Calculate the amount saved towards this savings target using the budget data
        Budget budget = this.getBudget();
        double amountSaved = budget.getSavingsTargetAmount(this);
        return amountSaved;
    }

}

