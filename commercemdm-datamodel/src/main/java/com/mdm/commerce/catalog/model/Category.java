package com.mdm.commerce.catalog.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by raghavan on 11/22/17.
 */
@Data
public class Category {

    private String name;
    private String description;
    private String longDescription;
    private String id;
    private boolean isRoot = Boolean.FALSE.booleanValue();
    private List<Category> childCategories;

}
