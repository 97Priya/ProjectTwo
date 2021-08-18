package com.projecttwo.digitalkitchen.api;

import com.projecttwo.digitalkitchen.model.Recipe;
import com.projecttwo.digitalkitchen.service.RecipeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class SearchRecipeController {

    @Autowired
    private RecipeService recipeService;

    private static final int size=4;

    @GetMapping("/all")
    public List<Recipe> findAllPaginated(@RequestParam("page") int page) {
        Page<Recipe> resultPage = recipeService.findnRecipe(page,size);
        return resultPage.getContent();
    }

    @GetMapping("paginated/{name}")
    public List<Recipe> getPaginatedRecipeByName(@RequestParam("page") int page,@PathVariable String name){
        Page<Recipe> resultPage =recipeService.getRecipeByName(page,size,name);
        return resultPage.getContent();
    }
    @GetMapping("/paginated")
    public List<Recipe> getPaginatedRecipeByCategory(@RequestParam("page") int page,@RequestParam String category){
        Page<Recipe> resultPage =recipeService.getRecipeByCategory(page,size,category);
        return resultPage.getContent();
    }

    @GetMapping("name/{name}")
    public List<Recipe> getRecipeByName(@PathVariable String name){
        List<Recipe> recipes =recipeService.getRecipeByName(name);
        return recipes;
    }

    @GetMapping("/")
    public List<Recipe> getRecipeByCategory(@RequestParam String category){
        System.out.println("inside controller method");
        return  recipeService.getRecipeByCategory(category);
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable ObjectId id){
        return recipeService.getRecipeById(id);
    }

}
