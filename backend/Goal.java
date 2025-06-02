<<<<<<< Updated upstream:backend/Goal.java
=======
package com.example.serving_web_content;

import jakarta.persistence.*;
>>>>>>> Stashed changes:serving-web-content/src/main/java/com/example/serving_web_content/Goal.java
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "goals")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private Long id;

    @Column(name = "user_id")
    private Integer userId;  

    @Column(name = "type_id")
    private Integer typeId;  
    @Column(name = "name")
    private String name;

    @Column(name = "target_amount")
    private double targetAmount;

    @Column(name = "target_date")
    private LocalDate targetDate;

    @Column(name = "current_savings")
    private double currentSavings;

    @Column(name = "monthly_contribution")
    private Double monthlyContribution;

    @Column(name = "recommended_contribution")
    private Double recommendedContribution;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Constructors

    public Goal() {}

    public Goal(Integer userId, Integer typeId, String name, double targetAmount, LocalDate targetDate, double currentSavings, Double monthlyContribution, Double recommendedContribution) {
        this.userId = userId;
        this.typeId = typeId;
        this.name = name;
        this.targetAmount = targetAmount;
        this.targetDate = targetDate;
        this.currentSavings = currentSavings;
        this.monthlyContribution = monthlyContribution;
        this.recommendedContribution = recommendedContribution;
    }

    // Getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public Integer getTypeId() { return typeId; }
    public void setTypeId(Integer typeId) { this.typeId = typeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getTargetAmount() { return targetAmount; }
    public void setTargetAmount(double targetAmount) { this.targetAmount = targetAmount; }

    public LocalDate getTargetDate() { return targetDate; }
    public void setTargetDate(LocalDate targetDate) { this.targetDate = targetDate; }

    public double getCurrentSavings() { return currentSavings; }
    public void setCurrentSavings(double currentSavings) { this.currentSavings = currentSavings; }

<<<<<<< Updated upstream:backend/Goal.java
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
=======
    public Double getMonthlyContribution() { return monthlyContribution; }
    public void setMonthlyContribution(Double monthlyContribution) { this.monthlyContribution = monthlyContribution; }

    public Double getRecommendedContribution() { return recommendedContribution; }
    public void setRecommendedContribution(Double recommendedContribution) { this.recommendedContribution = recommendedContribution; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}

>>>>>>> Stashed changes:serving-web-content/src/main/java/com/example/serving_web_content/Goal.java
