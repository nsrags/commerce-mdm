package com.mdm.commerce;

import com.mdm.commerce.catalog.model.Category;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class AppMain
{
    public static void main( String[] args )
    {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("data-config/catalog-datasource-config.xml");
    }
}
