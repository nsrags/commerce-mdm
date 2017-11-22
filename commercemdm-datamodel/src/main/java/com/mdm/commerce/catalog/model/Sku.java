package com.mdm.commerce.catalog.model;

import lombok.Data;

import java.util.List;

/**
 * Created by raghavan on 11/22/17.
 */
@Data
public class Sku {

    private String id;
    private String name;
    private String description;
    private String longDescription;
    private List<Product> parentProducts;
}
