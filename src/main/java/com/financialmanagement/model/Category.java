package com.financialmanagement.model;

public enum Category {
    //According to 2020 Consumer Expenditure Survey conducted by the U.S. Bureau of Labor Statistics.
    ALL ("All", 0.82),
    HOUSING("Housing", 0.15),
    TRANSPORTATION("Transportation", 0.12),
    UTILITIES("Utilities", 0.10),
    FOOD ("Food", 0.09),
    ENTERTAINMENT("Entertainment", 0.03);

    private String category;
    private double nationPercentage;

    Category(String category, double nationalPercentage) {
        this.category = category;
        this.nationPercentage = nationalPercentage;
    }

    public String category() {
        return category;
    }

    public double percentage() {
        return nationPercentage;
    }
}
