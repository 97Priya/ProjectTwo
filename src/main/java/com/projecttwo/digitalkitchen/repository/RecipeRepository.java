package com.projecttwo.digitalkitchen.repository;

import com.projecttwo.digitalkitchen.model.Recipe;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, ObjectId> {

    public List<Recipe> findByName(final String name);


 //   @Query("{'category': ?category}")
 //List<Recipe> findByCategory(String category);

    List<Recipe> findByCategoryIn(List<String> category);
}
