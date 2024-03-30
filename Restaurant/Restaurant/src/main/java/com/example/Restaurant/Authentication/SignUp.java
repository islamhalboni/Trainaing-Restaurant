package com.example.Restaurant.Authentication;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SignUp {

    private final AuthRepo authRepo;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity createAccount(@RequestBody Auth auth){
        try {
            if (authRepo.findByUsername(auth.getUsername()).isPresent())
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already taken. Please try again");
            auth.setPassword(passwordEncoder.encode(auth.getPassword()));
            Auth save = authRepo.save(auth);
            return ResponseEntity.ok(HttpStatus.CREATED);
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
