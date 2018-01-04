package com.mdm.commerce;

import com.mdm.commerce.admin.model.ChangeSet;
import com.mdm.commerce.admin.model.ChangeSetStatus;
import com.mdm.commerce.admin.repository.ChangeSetRepository;
import com.mdm.commerce.catalog.model.Category;
import com.mdm.commerce.catalog.model.Product;
import com.mdm.commerce.catalog.model.Sku;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by raghavan on 12/14/17.
 */
public class ChangeSetMain {
    public static void main(String[] args) {

        System.setProperty("env","dev");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("data-config/admin-datasource-config.xml");
        ChangeSetRepository changeSetRepository = context.getBean("changeSetRepository", ChangeSetRepository.class);

        performChangesetLoad(changeSetRepository);
        performChangeSetUpdate(changeSetRepository);
        performChangeSetUpdateForProduct(changeSetRepository);
        performChangeSetUpdateForSku(changeSetRepository);

    }

    private static void performChangeSetUpdateForSku(ChangeSetRepository changeSetRepository) {
        List<ChangeSet> changeSets  = changeSetRepository.findAll();
        ChangeSet changeSet = changeSetRepository.findOne(changeSets.get(0).getId());


        Sku newSku = new Sku();
        newSku.setId(UUID.randomUUID().toString());
        newSku.setDescription("New Sku  Description");
        newSku.setLongDescription("New Sku Long Description");
        newSku.setName("Apple Ipad-64GB-Black");

        changeSet.getSkus().add(newSku);
        changeSet.setLastUpdate(new Date());
        changeSet.setStatus(ChangeSetStatus.INITIAL);

        changeSetRepository.save(changeSet);

    }

    private static void performChangeSetUpdateForProduct(ChangeSetRepository changeSetRepository) {

        List<ChangeSet> changeSets  = changeSetRepository.findAll();
        ChangeSet changeSet = changeSetRepository.findOne(changeSets.get(0).getId());


        Product newProduct = new Product();
        newProduct.setId(UUID.randomUUID().toString());
        newProduct.setDescription("New Product  Description");
        newProduct.setLongDescription("New Product Long Description");
        newProduct.setName("Apple IPad");

        changeSet.getProducts().add(newProduct);
        changeSet.setLastUpdate(new Date());
        changeSet.setStatus(ChangeSetStatus.INITIAL);

        changeSetRepository.save(changeSet);

    }

    private static void performChangeSetUpdate(ChangeSetRepository changeSetRepository) {

        List<ChangeSet> changeSets  = changeSetRepository.findAll();
        ChangeSet changeSet = changeSetRepository.findOne(changeSets.get(0).getId());


        Category newCategory = new Category();
        newCategory.setId(UUID.randomUUID().toString());
        newCategory.setDescription("New Category Description");
        newCategory.setName("Shoes");
        newCategory.setRoot(Boolean.FALSE.booleanValue());
        newCategory.setLongDescription("Shoes"+"-Long Description");

        changeSet.getCategories().add(newCategory);
        changeSet.setStatus(ChangeSetStatus.INITIAL);

        changeSetRepository.save(changeSet);

    }

    private static void performChangesetLoad(ChangeSetRepository changeSetRepository) {

        changeSetRepository.deleteAll();

        ChangeSet newChangeSet = new ChangeSet();
        newChangeSet.setId(UUID.randomUUID().toString());
        newChangeSet.setName("New Category Addition");
        newChangeSet.setCreatedBy("Raghavan");
        newChangeSet.setStatus(ChangeSetStatus.NEW);
        changeSetRepository.save(newChangeSet);



    }
}
