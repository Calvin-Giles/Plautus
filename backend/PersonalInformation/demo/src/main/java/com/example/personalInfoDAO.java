package com.example;
//import com.example.PersonalInformation;
import java.sql.*;

public class personalInfoDAO {
 private final Connection connection;

    public personalInfoDAO(Connection connection) {
        this.connection = connection;
    }

    public void savePersonalInfo(int userId, PersonalInformation personalInfo) throws SQLException {
        String sql = "INSERT INTO personal_information " +
                     "(user_id, current_age, annual_income, years_until_retirement, " +
                     "retirement_goal, compound_annual_growth_rate, monthly_saving, " +
                     "initial_investment, smart_risk) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE " +
                     "current_age = VALUES(current_age), " +
                     "annual_income = VALUES(annual_income), " +
                     "years_until_retirement = VALUES(years_until_retirement), " +
                     "retirement_goal = VALUES(retirement_goal), " +
                     "compound_annual_growth_rate = VALUES(compound_annual_growth_rate), " +
                     "monthly_saving = VALUES(monthly_saving), " +
                     "initial_investment = VALUES(initial_investment), " +
                     "smart_risk = VALUES(smart_risk)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, personalInfo.getAge());
            stmt.setDouble(3, personalInfo.getIncome());
            stmt.setInt(4, personalInfo.getYearsToRetirement());
            stmt.setDouble(5, personalInfo.getRetirementGoal());
            stmt.setDouble(6, personalInfo.getCagr());
            stmt.setDouble(7, personalInfo.getMonthlySaving());
            stmt.setDouble(8, personalInfo.getInitialInvestment());
            stmt.setString(9, personalInfo.getRiskProfile().toLowerCase());
            
            stmt.executeUpdate();
        }
    }
}
