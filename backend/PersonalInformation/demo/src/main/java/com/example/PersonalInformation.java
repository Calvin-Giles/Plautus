package com.example;

/*
 * PersonalInformation: model for storing personal financial details related to a user’s retirement planning
 */
public class PersonalInformation {
// Fields (attribute): Stores user-specific financial details needed for retirement planning.
    private String userId;
    private int age;
    private double income;
    private int yearsToRetirement;
    private double retirementGoal;
    private double cagr;
    private double monthlySaving;
    private double initialInvestment;
    private String riskProfile;

    // Constructors 
    public PersonalInformation() {} //Default constructo

    public PersonalInformation(String userId, int age, double income, int yearsToRetirement, 
                       double retirementGoal, double cagr, double monthlySaving, 
                       double initialInvestment, String riskProfile) { //Parameterized constructor
        this.userId = userId;
        this.age = age;
        this.income = income;
        this.yearsToRetirement = yearsToRetirement;
        this.retirementGoal = retirementGoal;
        this.cagr = cagr;
        this.monthlySaving = monthlySaving;
        this.initialInvestment = initialInvestment;
        this.riskProfile = riskProfile;
    }

    /*Getters & Setters Provides controlled access to private fields*/
    public String getUserId() { 
        return userId; 
    }
    public void setUserId(String userId) { 
        this.userId = userId; 
    }

    public int getAge() { 
        return age; 
    }

    public void setAge(int age) { 
        this.age = age; 
    }

    public double getIncome() { 
        return income; 
    }

    public void setIncome(double income) { 
        this.income = income; 
    }

    public int getYearsToRetirement() { 
        return yearsToRetirement; 
    }

    public void setYearsToRetirement(int yearsToRetirement) { 
        this.yearsToRetirement = yearsToRetirement; 
    }

    public double getRetirementGoal() { 
        return retirementGoal; 
    }

    public void setRetirementGoal(double retirementGoal) { 
        this.retirementGoal = retirementGoal; 
    }

    public double getCagr() { 
        return cagr; 
    }

    public void setCagr(double cagr) { 
        this.cagr = cagr; 
    }

    public double getMonthlySaving() { 
        return monthlySaving; 
    }

    public void setMonthlySaving(double monthlySaving) { 
        this.monthlySaving = monthlySaving; 
    }

    public double getInitialInvestment() { 
        return initialInvestment; 
    }

    public void setInitialInvestment(double initialInvestment) { 
        this.initialInvestment = initialInvestment; 
    }

    public String getRiskProfile() { 
        return riskProfile; 
    }

    public void setRiskProfile(String riskProfile) { 
        this.riskProfile = riskProfile; 
    }

}
