package com.example.serving_web_content;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class InvestmentController {

    @PostMapping("/investment-advice")
    public Investment getInvestmentAdvice(@RequestBody UserInfo userInfo) {
        double r = userInfo.getGrowthRate() / 100.0;
        int n = userInfo.getYearsUntilRetirement();
        double FV = userInfo.getRetirementGoal();

        if (r <= 0 || n <= 0) {
            return new Investment("Invalid input: growth rate and years must be positive.", false);
        }

        //PMT = FV / [ ((1 + r)^n - 1) / r ]
        double denominator = (Math.pow(1 + r, n) - 1) / r;
        double annualInvestment = FV / denominator;
        double monthlyInvestment = annualInvestment / 12.0;

        if (annualInvestment > userInfo.getAnnualIncome()*0.5) {
            //If required savings is more than 50% of income, not realistic goal
            String message = "Based on your inputs, you need to focus on raising your income to achieve this goal.";
            return new Investment(message, false);
        } else {
            //investment plan:
            String message = String.format(
                "To reach your goal, you should invest approximately $%.2f per year (~$%.2f per month) at %.2f%% annual growth.",
                annualInvestment, monthlyInvestment, userInfo.getGrowthRate()
            );
            return new Investment(message, true);
        }
    }
}
