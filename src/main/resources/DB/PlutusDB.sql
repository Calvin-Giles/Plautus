-- Create the database
CREATE DATABASE IF NOT EXISTS plautus_applications;
USE plautus_applications;

-- Users table 
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    is_admin BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Personal information table
CREATE TABLE personal_information (
    info_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    current_age INT NOT NULL,
    annual_income DECIMAL(15, 2) NOT NULL,
    years_until_retirement INT NOT NULL,
    retirement_goal DECIMAL(15, 2) NOT NULL,
    compound_annual_growth_rate DECIMAL(5, 2) NOT NULL,
    monthly_saving DECIMAL(15, 2) NOT NULL,
    initial_investment DECIMAL(15, 2) NOT NULL,
    smart_risk ENUM('low', 'medium', 'high') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- Goal types table
CREATE TABLE goal_types (
    type_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description TEXT
);

-- Corrected INSERT statement for goal_types
INSERT INTO goal_types (name, description) VALUES
    ('Retirement', 'Saving for retirement'),
    ('Emergency Fund', 'Building an emergency fund'),
    ('Vacation', 'Saving for a vacation'),
    ('Home Down Payment', 'Saving for a home down payment');

-- Goals table
CREATE TABLE goals (
    goal_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    type_id INT,
    name VARCHAR(100) NOT NULL,
    target_amount DECIMAL(15, 2) NOT NULL,
    target_date DATE NOT NULL,
    current_savings DECIMAL(15, 2) DEFAULT 0,
    monthly_contribution DECIMAL(15, 2),
    recommended_contribution DECIMAL(15, 2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (type_id) REFERENCES goal_types(type_id)
);

-- Insight content table
CREATE TABLE insight_content (
    content_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    author VARCHAR(100),
    status ENUM('pending', 'approved', 'rejected') DEFAULT 'pending',
    submitted_by INT,
    reviewed_by INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (submitted_by) REFERENCES users(user_id),
    FOREIGN KEY (reviewed_by) REFERENCES users(user_id)
);

-- Flagged activities table
CREATE TABLE flagged_activities (
    activity_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    activity_type ENUM('failed_login', 'unusual_input', 'account_change') NOT NULL,
    description TEXT NOT NULL,
    severity ENUM('low', 'medium', 'high') NOT NULL,
    status ENUM('pending', 'reviewed', 'resolved') DEFAULT 'pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Password reset tokens table
CREATE TABLE password_reset_tokens (
    token_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    token VARCHAR(255) NOT NULL,
    expires_at TIMESTAMP NOT NULL,
    used BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- User sessions table
CREATE TABLE user_sessions (
    session_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    token VARCHAR(255) NOT NULL,
    ip_address VARCHAR(45),
    user_agent TEXT,
    expires_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);