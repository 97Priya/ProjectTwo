package com.projecttwo.digitalkitchen.repository;

import com.projecttwo.digitalkitchen.model.Recipe;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, ObjectId> {

    Page<Recipe> findAll(Pageable pageable);

    Page<Recipe> findByName(String name,Pageable pageable);

    Page<Recipe> findByCategoryIn(List<String> category,Pageable pageable);

    public List<Recipe> findByName(final String name);

    List<Recipe> findByCategoryIn(List<String> category);
}
