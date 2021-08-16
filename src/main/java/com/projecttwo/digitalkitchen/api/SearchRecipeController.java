package com.projecttwo.digitalkitchen.api;

import com.projecttwo.digitalkitchen.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class SearchRecipeController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/recipes/{name}")
    public void getRecipe(@PathVariable String name){
        recipeService.getRecipeByName(name);
    }

}
