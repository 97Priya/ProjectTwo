package com.projecttwo.digitalkitchen.repository;

import com.projecttwo.digitalkitchen.model.Recipe;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, ObjectId> {

    public List<Recipe> findByName(String name);
}
