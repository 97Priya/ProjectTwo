package com.projecttwo.digitalkitchen.api;

import com.projecttwo.digitalkitchen.model.Recipe;
import com.projecttwo.digitalkitchen.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class SearchRecipeController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/{name}")
    public List<Recipe> getRecipeByName(@PathVariable String name){
        System.out.println(name);
        List<Recipe> recipes =recipeService.getRecipeByName(name);
        return recipes;
    }

    @GetMapping("/")
    public List<Recipe> getRecipeByCategory(@RequestParam String category){
        System.out.println("inside controller method");
        return  recipeService.getRecipeByCategory(category);
    }

}
