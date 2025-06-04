package com.example.serving_web_content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    public Map<String, Object> registerUser(@RequestBody Map<String, String> userMap) {
        Map<String, Object> response = new HashMap<>();

        try {
            String username = userMap.get("username");
            String email = userMap.get("email");
            String password = userMap.get("password");

            if (userRepository.findByUsername(username) != null) {
                response.put("success", false);
                response.put("message", "Username already taken");
                return response;
            }

            if (userRepository.findByEmail(email) != null) {
                response.put("success", false);
                response.put("message", "Email already registered");
                return response;
            }

            User newUser = new User();
            newUser.setUsername(username);
            newUser.setEmail(email);
            newUser.setPasswordHash(passwordEncoder.encode(password));
            newUser.setIsAdmin(false);

            userRepository.save(newUser);

            response.put("success", true);
            response.put("message", "Account created successfully");

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "An error occurred: " + e.getMessage());
        }

        return response;
    }

    @PostMapping("/login")
    public Map<String, Object> loginUser(@RequestBody Map<String, String> loginMap) {
        Map<String, Object> response = new HashMap<>();

        try {
            String username = loginMap.get("username");
            String password = loginMap.get("password");

            User user = userRepository.findByUsername(username);

            if (user != null && passwordEncoder.matches(password, user.getPasswordHash())) {
                response.put("success", true);
                response.put("message", "Login successful");
            } else {
                response.put("success", false);
                response.put("message", "Invalid username or password");
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "An error occurred: " + e.getMessage());
        }

        return response;
    }
}
