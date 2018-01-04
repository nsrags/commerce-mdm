package com.mdm.commerce;

import com.mdm.commerce.admin.repository.ChangeSetRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by raghavan on 1/4/18.
 */
public class OrderTestMain {
    public static void main(String[] args) {
        System.setProperty("env","dev");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("data-config/order-datasource-config.xml");
        JdbcTemplate orderTemplate = context.getBean("orderJdbcTemplate",JdbcTemplate.class);

        List<Map<String, Object>> rows = orderTemplate.queryForList("select * from mdm_order");
        for (Map row : rows) {
            long id = (Long)row.get("id");
            double amount = (Double) row.get("amount");
            String description = (String)row.get("description");

            System.out.println("Total Row ::"+ id +"===="+amount+"===="+description);

            
        }

    }
}
