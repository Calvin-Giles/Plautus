package com.example.serving_web_content;

public class Investment {
    private String advice;
    private boolean achievable;

    public Investment(String advice, boolean achievable) {
        this.advice = advice;
        this.achievable = achievable;
    }

    public String getAdvice() { return advice; }
    public boolean isAchievable() { return achievable; }
}
