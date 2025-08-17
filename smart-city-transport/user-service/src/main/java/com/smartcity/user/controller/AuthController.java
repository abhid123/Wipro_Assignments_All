package com.smartcity.user.controller;

import com.smartcity.user.model.User;
import com.smartcity.user.repo.UserRepository;
import com.smartcity.user.security.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository repo;
    private final PasswordEncoder encoder = new BCryptPasswordEncoder();
    private final JwtService jwtService;

    public AuthController(UserRepository repo, JwtService jwtService) {
        this.repo = repo;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User u){
        if (repo.findByEmail(u.getEmail()) != null) throw new ResponseStatusException(HttpStatus.CONFLICT, "Email exists");
        u.setHashedPassword(encoder.encode(u.getHashedPassword()));
        repo.save(u);
        return Map.of("id", u.getId(), "message", "registered");
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String,String> body){
        String email = body.get("email");
        String password = body.get("password");
        User u = repo.findByEmail(email);
        if (u == null || !encoder.matches(password, u.getHashedPassword()))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        String token = jwtService.generateToken(email);
        return Map.of("token", token, "email", email);
    }
}
