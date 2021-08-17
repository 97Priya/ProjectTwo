package com.projecttwo.digitalkitchen.service;

import com.projecttwo.digitalkitchen.model.Recipe;
import com.projecttwo.digitalkitchen.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    public List<Recipe> getRecipeByName(String recipeName){
      return recipeRepository.findByName(recipeName);
    }

    public List<Recipe> getRecipeByCategory(String category){

        System.out.println("inside service");

        return  recipeRepository.findByCategoryIn(Arrays.asList(category));
    }
}
