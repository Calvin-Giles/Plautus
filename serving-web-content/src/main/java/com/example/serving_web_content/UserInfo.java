package com.example.serving_web_content;

public class UserInfo {

    private double annualIncome;
    private double growthRate;
    private int yearsUntilRetirement;
    private double retirementGoal;


    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public double getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(double growthRate) {
        this.growthRate = growthRate;
    }

    public int getYearsUntilRetirement() {
        return yearsUntilRetirement;
    }

    public void setYearsUntilRetirement(int yearsUntilRetirement) {
        this.yearsUntilRetirement = yearsUntilRetirement;
    }

    public double getRetirementGoal() {
        return retirementGoal;
    }

    public void setRetirementGoal(double retirementGoal) {
        this.retirementGoal = retirementGoal;
    }
}

