package com.example.serving_web_content;

public class UserInfo {
    private int currentAge;
    private double annualIncome;
    private int yearsUntilRetirement;
    private double retirementGoal;
    private double growthRate;

    //getters and setters
    public int getCurrentAge() { return currentAge; }
    public void setCurrentAge(int currentAge) { this.currentAge = currentAge; }

    public double getAnnualIncome() { return annualIncome; }
    public void setAnnualIncome(double annualIncome) { this.annualIncome = annualIncome; }

    public int getYearsUntilRetirement() { return yearsUntilRetirement; }
    public void setYearsUntilRetirement(int yearsUntilRetirement) { this.yearsUntilRetirement = yearsUntilRetirement; }

    public double getRetirementGoal() { return retirementGoal; }
    public void setRetirementGoal(double retirementGoal) { this.retirementGoal = retirementGoal; }

    public double getGrowthRate() { return growthRate; }
    public void setGrowthRate(double growthRate) { this.growthRate = growthRate; }
}
