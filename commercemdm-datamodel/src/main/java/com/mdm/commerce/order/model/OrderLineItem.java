package com.mdm.commerce.order.model;

import lombok.Data;

import javax.money.CurrencyUnit;

/**
 * Created by raghavan on 11/22/17.
 */
@Data
public class OrderLineItem {

    private String id;
    private String totalAmount;
    private CurrencyUnit currencyUnit;
    private String parentOrder;


}
