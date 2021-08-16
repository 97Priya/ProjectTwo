package com.projecttwo.digitalkitchen.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Recipe {

    @Id
    private ObjectId _id;
    private String name;
    private int prepration_time;
    private int total_time;
    private List<Ingredient> ingredients;
    private  List<String> steps;
    private List<String> category;
    private int rating;
    private User user_id;
    private List<Nutrient> nutrients;


    public Recipe() {
    }

    public Recipe(String name, int prepration_time, int total_time, List<Ingredient> ingredients, List<String> steps, List<String> category, int rating, User user_id, List<Nutrient> nutrients) {
        this.name = name;
        this.prepration_time = prepration_time;
        this.total_time = total_time;
        this.ingredients = ingredients;
        this.steps = steps;
        this.category = category;
        this.rating = rating;
        this.user_id = user_id;
        this.nutrients = nutrients;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrepration_time() {
        return prepration_time;
    }

    public void setPrepration_time(int prepration_time) {
        this.prepration_time = prepration_time;
    }

    public int getTotal_time() {
        return total_time;
    }

    public void setTotal_time(int total_time) {
        this.total_time = total_time;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public List<Nutrient> getNutrients() {
        return nutrients;
    }

    public void setNutrients(List<Nutrient> nutrients) {
        this.nutrients = nutrients;
    }
}
