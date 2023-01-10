package com.financialmanagement.model;

public enum SavingsType {
  SHORT_TERM("Short-Term"),
  MEDIUM_TERM("Medium-Term"),
  LONG_TERM("Long-Term");

  private String name;

  private SavingsType(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}
