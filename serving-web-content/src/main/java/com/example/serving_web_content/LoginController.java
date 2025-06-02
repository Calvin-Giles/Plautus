package com.example.serving_web_content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return new LoginResponse("Login successful", true);
        } else {
            return new LoginResponse("Invalid username or password", false);
        }
    }
}
