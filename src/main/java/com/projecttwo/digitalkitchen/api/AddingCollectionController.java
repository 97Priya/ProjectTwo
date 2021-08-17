package com.projecttwo.digitalkitchen.api;

import com.projecttwo.digitalkitchen.model.Recipe;
import com.projecttwo.digitalkitchen.model.User;
import com.projecttwo.digitalkitchen.repository.RecipeRepository;
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
    private UserRepository userRepository;

   @Autowired
   private RecipeRepository recipeRepository;

    @PostMapping("/private/recipes")
    public String addNewRecipe(@RequestBody Recipe recipe){
        recipeRepository.save(recipe);
        return "new recipe added";
    }

    @PostMapping(value = "/users")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        System.out.println("REGISTERING A USER............................................................");
            userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
