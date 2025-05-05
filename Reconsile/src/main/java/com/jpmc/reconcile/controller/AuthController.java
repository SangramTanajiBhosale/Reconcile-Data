package com.jpmc.reconcile.controller;

import com.jpmc.reconcile.entity.AuthRequest;
import com.jpmc.reconcile.entity.AuthResponse;
import com.jpmc.reconcile.entity.fidCredentional;
import com.jpmc.reconcile.repository.fidCredentionalRepo;
import com.jpmc.reconcile.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/authenticate")
public class AuthController {
    @Autowired
    private fidCredentionalRepo repository;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/fid-cred")
    public ResponseEntity<?> authenticate(@RequestHeader("username") String username, @RequestHeader("password") String password) {
        Optional<fidCredentional> optionalUser = repository.findByusername(username);

        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        fidCredentional user = optionalUser.get();

        if (!password.equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        String token = jwtUtil.generateToken(user.getUsername());

        return ResponseEntity.ok(new AuthResponse(token));
    }
}
