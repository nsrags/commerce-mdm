package com.mdm.commerce;

import com.mdm.commerce.catalog.model.Category;
import com.mdm.commerce.catalog.model.Product;
import com.mdm.commerce.catalog.model.Sku;
import com.mdm.commerce.catalog.repository.CategoryRepository;
import com.mdm.commerce.catalog.repository.ProductRepository;
import com.mdm.commerce.catalog.repository.SkuRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class AppMain
{

    private static List<String> categoryNames = Arrays.asList("Shoes","Watches","Electronics","Laptops","SmartPhones",
            "Books","Office Supplies","Toys","Video Games","Footwear");
    
    private static List<String> productNames  = Arrays.asList("Apple-IPad","LG SmartTV","UA-Running Shoe","Think & Grow Rich",
            "Barbie Girl","Hangman","Ruosh Men Sandal","Pilot Gel Pen","Fossil Smart Watch","Google Pixel2 XL");

    private static List<String> skuNames   = Arrays.asList("Apple-IPad-32GB-White","LG SmartTV-32'","UA-Running Shoe-Size9-Black","Think & Grow Rich-Kindle",
            "Barbie Girl-Small","Hangman-Full Series","Ruosh Men Sandal-Black-Size9","Pilot Gel Pen-Blue","Fossil Smart Watch-Blue","Google Pixel2 XL-64GB-Grey");



    public static void main( String[] args )
    {
        System.setProperty("env","dev");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("data-config/catalog-datasource-config.xml");
        CategoryRepository categoryRepository = context.getBean("categoryRepository",CategoryRepository.class);
        ProductRepository productRepository = context.getBean("productRepository",ProductRepository.class);
        SkuRepository skuRepository = context.getBean("skuRepository",SkuRepository.class);

        performCategoryLoad(categoryRepository);
        performCategoryRetrievalTest(categoryRepository);
        performCategoryDeletionTest(categoryRepository);

        performProductLoad(productRepository);
        performProductRetrievalTest(productRepository);
        performProductDeletionTest(productRepository);

        performSkuLoad(skuRepository);
        performSkuRetrieval(skuRepository);
        performSkuDeletionTest(skuRepository);


    }

    private static void performSkuDeletionTest(SkuRepository skuRepository) {
        Sku skuToDelete  =  skuRepository.findByName(skuNames.get(3));
        skuRepository.delete(skuToDelete.getId());
        System.out.println("Total Skus Size after deletion :: "+skuRepository.findAll().size());

    }

    private static void performSkuRetrieval(SkuRepository skuRepository) {
        List<Sku> allSkus  = skuRepository.findAll();
        System.out.println("Total Skus  count ::"+allSkus.size());

        Sku  skuFound  = skuRepository.findByName(skuNames.get(3));
        System.out.println("Sku  Retrieved ::"+skuFound.getName() +"...For Input .."+ skuNames.get(3));

    }

    private static void performSkuLoad(SkuRepository skuRepository) {

        skuRepository.deleteAll();
        for(int i = 0; i< skuNames.size(); i++) {
            Sku newSku = new Sku();
            newSku.setId(UUID.randomUUID().toString());
            newSku.setDescription(skuNames.get(i)+"- Description");
            newSku.setLongDescription(skuNames.get(i)+"- Long Description");
            newSku.setName(skuNames.get(i));
            skuRepository.save(newSku);
        }


    }

    private static void performProductDeletionTest(ProductRepository productRepository) {
        Product productToDelete  =  productRepository.findByName(productNames.get(3));
        productRepository.delete(productToDelete.getId());
        System.out.println("Total Products Size after deletion :: "+productRepository.findAll().size());

    }

    private static void performProductRetrievalTest(ProductRepository productRepository) {
        List<Product> allProducts  = productRepository.findAll();
        System.out.println("Total Products  count ::"+allProducts.size());

        Product  productFound  = productRepository.findByName(productNames.get(3));
        System.out.println("Product  Retrieved ::"+productFound.getName() +"...For Input .."+ productNames.get(3));
    }

    private static void performProductLoad(ProductRepository productRepository) {
        productRepository.deleteAll();
        for(int i = 0; i< productNames.size(); i++) {
            Product newProduct = new Product();
            newProduct.setId(UUID.randomUUID().toString());
            newProduct.setDescription(productNames.get(i)+"- Description");
            newProduct.setLongDescription(productNames.get(i)+"- Long Description");
            newProduct.setName(productNames.get(i));
            productRepository.save(newProduct);
        }
    }

    private static void performCategoryDeletionTest(CategoryRepository categoryRepository) {

       Category categoryToDelete  =  categoryRepository.findByName(categoryNames.get(3));
       categoryRepository.delete(categoryToDelete.getId());
       System.out.println("Total Categories Size after deletion :: "+categoryRepository.findAll().size());

    }


    private static void performCategoryRetrievalTest(CategoryRepository categoryRepository) {
        List<Category> allCategories = categoryRepository.findAll();
        System.out.println("Total Categories count ::"+allCategories.size());

        Category categoryFound = categoryRepository.findByName(categoryNames.get(3));
        System.out.println("Category Retrieved ::"+categoryFound.getName() +"...For Input .."+ categoryNames.get(3));

    }




    public static void performCategoryLoad(CategoryRepository categoryRepository){

        categoryRepository.deleteAll();
        for(int i = 0; i< categoryNames.size(); i++) {
            Category newCategory = new Category();
            newCategory.setId(UUID.randomUUID().toString());
            newCategory.setDescription("New Category Description");
            newCategory.setName(categoryNames.get(i));
            newCategory.setRoot(Boolean.FALSE.booleanValue());
            newCategory.setLongDescription(categoryNames.get(i));
            categoryRepository.save(newCategory);
        }




    }
}
