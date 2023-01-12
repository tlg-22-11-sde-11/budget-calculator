package com.financialmanagement.model;

public enum SavingsType {
  EMERGENCY_FUND("Emergency Fund"),
  VACATION("Vacation"),
  OTHER("Other");


  private String name;

  SavingsType(String name) {
    this.name = name;
  }

  public String toString() {
    return name;
  }

  public SavingsType valueOf() {
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

  public void choseType(int choice) throws IllegalArgumentException{
    if (choice >= 1 && choice <= 3) {
      throw new IllegalArgumentException("Choice must be between 1-3 ");
    }
  }

}
