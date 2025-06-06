package com.example.serving_web_content;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Represents a Goal entity to be persisted in the database.
 * Each goal has a unique ID, name, and description.
 * This entity can be used to track objectives, tasks, or milestones.
 * @author 
 */
@Entity
public class Goal {
    /**
     * The identifier for a goal.
     * It is automatically generated by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the goal.
     */
    private String name;

    /**
     * A description of the goal.
     */
    private String description;

    /**
     * Default constructor required by JPA.
     */
    public Goal() {
    }

    /**
     * Constructs a new Goal
     * 
     * @param name the name of the goal
     * @param description the description of the goal
     */
    public Goal(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Returns the identifier of the goal.
     * 
     * @return the goal's ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the identifier of the goal.
     * 
     * @param id the goal's ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the goal.
     * 
     * @return the goal's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the goal.
     * 
     * @param name the goal's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the description of the goal.
     * 
     * @return the goal's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the goal.
     * 
     * @param description the goal's description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}

