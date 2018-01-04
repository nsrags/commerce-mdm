package com.mdm.commerce.order.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.money.CurrencyUnit;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by raghavan on 11/22/17.
 */
@Data
public class Order {

    private String id;
    private String description;
    private BigDecimal totalAmount;
    private CurrencyUnit currencyUnit;
    private List<OrderLineItem> lineItems;
}
