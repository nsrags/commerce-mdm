package com.mdm.commerce.admin.repository;

import com.mdm.commerce.admin.model.ChangeSet;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by raghavan on 12/14/17.
 */
public interface ChangeSetRepository  extends MongoRepository<ChangeSet,String>{

    public ChangeSet findByName(String name);
}
