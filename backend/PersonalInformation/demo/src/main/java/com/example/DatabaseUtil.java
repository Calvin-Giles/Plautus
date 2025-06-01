//package com.example;
import java.sql.*;

public class DatabaseUtil {
	public static  Connection con= null;
	
	/**
	 * Code to connect to Plutus DataBase
	 */
	public static void connection() {
		String url ="jdbc:mysql://localhost:3306/plautus_applications";
		String username="root";
		String pass = "";
		
		/**
		 * establish a database connection
		 */
		try {
		    con = DriverManager.getConnection(url, username, pass);
		    System.out.println("Connected to database");
		} 
		catch (Exception e) {
		    System.out.println("Exception: " + e.getMessage()); 
		}

	}
	public class DatabaseSchema {
		/**
		 *Users Table (stores all user accounts)
		 */
		public static final String User_table= "users";
		public static final String userId="user_id";
		public static final String userName="username";
		public static final String Email="email";
		public static final String pass_hash="password_hash";
		public static final String isAdmin="is_admin";
		public static final String User_createdAt="created_at"; //for admin
		public static final String User_updatedAt="updated_at"; //Admin
		
		/**
		 * Personal Information Table  (stores financial details) 
		 */
		public static final String PersonalInfo= "personal_information";
		public static final String infoId= "info_id";
		public static final String Personal_userId=userId; //Reusing user if from User_table
		public static final String CurrentAge= "current_age";
		public static final String AnnualIncome= "annual_income";
		public static final String YearTillRetirement= "years_until_retirement";
		public static final String retirementGoal= "retirement_goal";
		public static final String CAGR= "compound_annual_growth_rate";
		public static final String monthlySaving= "monthly_saving";
		public static final String initInvest= "initial_investment";
		public static final String Risk= "smart_risk";
		public static final String personal_created= "created_at";
		public static final String personalUpdated= "updated_at";
		
		/**
		 * Table for Goal Type (stores predefined goal categories) 
		 */
		public static final String GoalType_TABLE = "goal_types";
	    public static final String TypeId = "type_id";
	    public static final String GoalName = "name";
	    public static final String Description = "description";
	    
	    /**
	     * Goals Table (stores user financial goals)
	     */ 
	    public static final String Goal_table = "goals";
	    public static final String GoalId = "goal_id";
	    public static final String Goal_UserId = userId; //Reusing user if from User_table
	    public static final String Goal_TypeId = TypeId; // Reusing type_id from Reusing
	    public static final String TargetAmount = "target_amount";
	    public static final String TargetDate = "target_date";
	    public static final String CurrentSavings = "current_savings";
	    public static final String MonthlyContribution = "monthly_contribution";
	    public static final String RecommendedContribution = "recommended_contribution";
	    
	    /**
	     * Insight content table (stores financial articles/tips for admin approval)
	     */ 
	    public static final String Insight_content = "insight_content";
	    public static final String ContentId = "content_id";
	    public static final String Title = "title"; 
	    public static final String Content = "content";
	    public static final String Author = "author";
	    public static final String Insight_Status = "status";
	    public static final String SubmittedBy = "submitted_by";
	    public static final String RviewedBy = "reviewed_by";
	    public static final String Insight_created = "created_at";
	    public static final String Insight_updated = "updated_at";
	    
	    /**
	     * Flagged activities table (stores suspicious activities)
	     */ 
	    public static final String flagged_activities = "flagged_activities";
	    public static final String activityId = "activity_id";
	    public static final String Flag_UserId = "user_id"; 
	    public static final String ActivityType = "activity_type";
	    public static final String Flagged_Description = "description";
	    public static final String Severity = "severity";
	    public static final String Flagged_Status = "status";
	    public static final String Flagged_created = "created_at";
	    public static final String Flagged_updated = "updated_at";
	    
	    /**
	     * Password reset tokens table
	     */ 
	    public static final String password_reset_tokens  = "password_reset_tokens ";
	    public static final String tokenID = "token_id";
	    public static final String token_userID = "user_id"; 
	    public static final String Token = "token";
	    public static final String Token_expire = "expires_at";
	    public static final String Token_used = "used";
	    public static final String Token_created = "created_at";
	    
	    /**
	     * Flagged activities table (stores suspicious activities)
	     */ 
	    public static final String user_sessions = "user_sessions";
	    public static final String sessionID = "session_id";
	    public static final String session_userID = "user_id"; 
	    public static final String session_token = "token";
	    public static final String IPAddress = "ip_address";
	    public static final String UserAgent = "user_agent";
	    public static final String session_Expires = "expires_at";
	    public static final String session_created = "created_at";
    }
    public static Connection getConnection() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getConnection'");
    }    
	
}
