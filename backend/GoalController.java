package com.example.serving_web_content;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/goals")
@CrossOrigin(origins = "*")
public class GoalController {

    @Autowired
    private GoalRepository goalRepository;

    @GetMapping
    public List<Goal> getGoals() {
        return goalRepository.findAll();
    }

    @PostMapping
    public Goal addGoal(@RequestBody Goal goal) {
        return goalRepository.save(goal);
    }
}

