package com.example;
import com.example.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.SQLException;

/*
 * personalInfoService: acts as the service layer between the servlet and the DAO (Data Access Object). 
 * It ensures validation, logging, and exception handling before interacting with the database
 */
public class personalInfoService {
    private static final Logger logger = LoggerFactory.getLogger(personalInfoService.class);
    private final personalInfoDAO personalInfoDAO;

    public personalInfoService() throws SQLException {
        this.personalInfoDAO = new personalInfoDAO(DatabaseUtil.getConnection());
    }

    public void savePersonalInfo(int userId, PersonalInformation personalInfo) throws ServiceException {
        try {
            // Validate input before saving
            validatePersonalInfo(personalInfo);
            
            // Save to database
            personalInfoDAO.savePersonalInfo(userId, personalInfo);
            
            logger.info("Successfully saved personal info for user ID: {}", userId);
        } catch (SQLException e) {
            logger.error("Failed to save personal information for user ID: " + userId, e);
            throw new ServiceException("Failed to save personal information", e);
        }
    }

    private void validatePersonalInfo(PersonalInformation personalInfo) throws ServiceException {
        if (personalInfo == null) {
            throw new ServiceException("Personal information cannot be null");
        }
        
        if (personalInfo.getAge() <= 0) {
            throw new ServiceException("Age must be positive");
        }
        
        if (personalInfo.getIncome() < 0) {
            throw new ServiceException("Income cannot be negative");
        }
        
        // Add more validation rules as needed
    }
}
