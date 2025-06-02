package com.example.serving_web_content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        Optional<User> userOpt = userRepository.findByUsername(request.getUsername());

        if (userOpt.isPresent()) {
            User user = userOpt.get();

            // TEMPORARY: Plaintext compare (you can add hashing later)
            if (user.getPasswordHash().equals(request.getPassword())) {
                return new LoginResponse(true, "Login successful", user.getUserId());
            }
        }

        return new LoginResponse(false, "Invalid username or password", null);
    }
}
