package com.financialmanagement.model;

public enum Category {
    ALL ("All", 82),
    HOUSING("Housing", 15),
    TRANSPORTATION("Transportation", 12),
    UTILITIES("Utilities", 10),
    FOOD ("Food", 9),
    ENTERTAINMENT("Entertainment", 3);

    private String category;
    private int nationPercentage;

    Category(String category, int nationalPercentage) {
        this.category = category;
        this.nationPercentage = nationalPercentage;
    }

    public String category() {
        return category;
    }

    public int percentage() {
        return nationPercentage;
    }
}
