package com.mdm.commerce.catalog.repository;

import com.mdm.commerce.catalog.model.Sku;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by raghavan on 12/14/17.
 */
public interface SkuRepository extends MongoRepository<Sku,String> {

    public Sku findByName(String name);
}
