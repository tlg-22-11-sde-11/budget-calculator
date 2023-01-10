package com.financialmanagement.model;

public enum Category {
    GROCERIES("Groceries"),
    HOUSING("Housing"),
    TRANSPORTATION("Transportation"),
    UTILITIES("Utilities"),
    INSURANCE("Insurance"),
    ENTERTAINMENT("Entertainment");

    private String name;

    private Category(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
