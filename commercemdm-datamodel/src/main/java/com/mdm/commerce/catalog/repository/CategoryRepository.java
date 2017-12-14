package com.mdm.commerce.catalog.repository;

import com.mdm.commerce.catalog.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by raghavan on 12/14/17.
 */
public interface CategoryRepository extends MongoRepository<Category,String>{

    public Category findByName(String name);
}
