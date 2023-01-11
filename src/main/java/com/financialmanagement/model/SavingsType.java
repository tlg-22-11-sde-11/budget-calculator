package com.financialmanagement.model;

public enum SavingsType {
  EMERGENCYFUND("Emergency Fund"),
  VACATION("Vacation"),
  OTHER("Other");


  private String name;

  SavingsType(String name) {
    this.name = name;
  }

  public String toString() {
    return name;
  }

  public static SavingsType valueOf() {
    for (SavingsType e : SavingsType.values()) {
      if (e.getName().equals(e.name)) {
        return e;
      }
    }
    throw new IllegalArgumentException("No such name exists in SavingsType Enum.");
  }

  public String getName() {
    return name;
  }
}
