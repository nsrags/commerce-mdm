package com.mdm.commerce.catalog.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by raghavan on 11/22/17.
 */
@Data
public class Sku {

    @Id
    private String id;
    private String name;
    private String description;
    private String longDescription;
    private List<Product> parentProducts;
}
