package com.example.vendingmachinetask.data;

import static com.example.vendingmachinetask.data.Products.PRICE_IN_CENTS_CANDY;
import static com.example.vendingmachinetask.data.Products.PRICE_IN_CENTS_CHIPS;
import static com.example.vendingmachinetask.data.Products.PRICE_IN_CENTS_COLA;
import static com.example.vendingmachinetask.data.Products.PRICE_IN_CENTS_UNASSIGNED_OR_FUTURE_USE;
import static com.example.vendingmachinetask.data.Products.PRODUCT_NAME_CANDY;
import static com.example.vendingmachinetask.data.Products.PRODUCT_NAME_CHIPS;
import static com.example.vendingmachinetask.data.Products.PRODUCT_NAME_COLA;
import static com.example.vendingmachinetask.data.Products.PRODUCT_UNASSIGNED_OR_FUTURE_USE;

/**
 * Defines product type for vending machine.
 */
public enum ProductType {
    COLA(PRODUCT_NAME_COLA, PRICE_IN_CENTS_COLA),
    CHIPS(PRODUCT_NAME_CHIPS, PRICE_IN_CENTS_CHIPS),
    CANDY(PRODUCT_NAME_CANDY, PRICE_IN_CENTS_CANDY),
    UNASSIGNED_OR_FUTURE_USE(PRODUCT_UNASSIGNED_OR_FUTURE_USE, PRICE_IN_CENTS_UNASSIGNED_OR_FUTURE_USE);

    private String mProductName;
    private int mPrice;

    /**
     * Creates and return {@link ProductType} corresponding to the product name.
     *
     * @param productName the name of the product
     * @return the type corresponding to the product name
     */
    public static ProductType create(String productName) {
        switch (productName) {
            case PRODUCT_NAME_COLA:
                return COLA;
            case PRODUCT_NAME_CHIPS:
                return CHIPS;
            case PRODUCT_NAME_CANDY:
                return CANDY;
            default:
                return UNASSIGNED_OR_FUTURE_USE;
        }
    }

    /**
     * Constructor for product type.
     *
     * @param productName the product name
     * @param price       the product price
     */
    ProductType(String productName, int price) {
        mProductName = productName;
        mPrice = price;
    }

    /**
     * Returns the code of product type.
     *
     * @return the code of product type
     */
    public int getPrice() {
        return mPrice;
    }

    /**
     * Returns the product name.
     *
     * @return the product name
     */
    public String getProductName() {
        return mProductName;
    }
}

