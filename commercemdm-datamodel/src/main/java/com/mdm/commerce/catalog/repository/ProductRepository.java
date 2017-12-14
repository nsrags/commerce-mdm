package com.mdm.commerce.catalog.repository;

import com.mdm.commerce.catalog.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by raghavan on 12/14/17.
 */
public interface ProductRepository extends MongoRepository<Product,String>
{
    public Product findByName(String name);
}
