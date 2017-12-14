package com.mdm.commerce.admin.model;

import com.mdm.commerce.catalog.model.Category;
import com.mdm.commerce.catalog.model.Product;
import com.mdm.commerce.catalog.model.Sku;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by raghavan on 12/14/17.
 */
@Data
public class ChangeSet {

    @Id
    private String id;
    private String name;
    private Date createdAt = new Date();
    private String createdBy;
    private ChangeSetStatus status;
    private Date lastUpdate = createdAt;

    private List<Category> categories = new ArrayList();
    private List<Product> products = new ArrayList();
    private List<Sku> skus = new ArrayList();

}
