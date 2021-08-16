package com.projecttwo.digitalkitchen.api;

import com.projecttwo.digitalkitchen.model.User;
import com.projecttwo.digitalkitchen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class AddingCollectionController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/private/recipes")
    public String addNewRecipe(Principal principal){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        System.out.println(principal.getName());
        System.out.println(authentication.getAuthorities());
        return "new recipe added";
    }

    @PostMapping("/public/users")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
