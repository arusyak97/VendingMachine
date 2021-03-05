package com.example.vendingmachinetask;

import com.example.vendingmachinetask.data.ProductType;
import com.example.vendingmachinetask.data.Products;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTypeTest {
    private ProductType mCola = ProductType.create(Products.PRODUCT_NAME_COLA);
    private ProductType mChips = ProductType.create(Products.PRODUCT_NAME_CHIPS);
    private ProductType mCandy = ProductType.create(Products.PRODUCT_NAME_CANDY);
    private ProductType mUnassigned = ProductType.create(Products.PRODUCT_UNASSIGNED_OR_FUTURE_USE);

    @Test
    public void testGetPriceCola() {
        assertEquals(Products.PRICE_IN_CENTS_COLA, mCola.getPrice());
    }

    @Test
    public void testGetPriceChips() {
        assertEquals(Products.PRICE_IN_CENTS_CHIPS, mChips.getPrice());
    }

    @Test
    public void testGetPriceCandy() {
        assertEquals(Products.PRICE_IN_CENTS_CANDY, mCandy.getPrice());
    }

    @Test
    public void testGetPriceUnassigned() {
        assertEquals(Products.PRICE_IN_CENTS_UNASSIGNED_OR_FUTURE_USE, mUnassigned.getPrice());
    }

    @Test
    public void testGetProductNameCola() {
        assertEquals(Products.PRODUCT_NAME_COLA, mCola.getProductName());
    }

    @Test
    public void testGetProductNameChips() {
        assertEquals(Products.PRODUCT_NAME_CHIPS, mChips.getProductName());
    }

    @Test
    public void testGetProductNameCandy() {
        assertEquals(Products.PRODUCT_NAME_CANDY, mCandy.getProductName());
    }

    @Test
    public void testGetProductNameUnassigned() {
        assertEquals(Products.PRODUCT_UNASSIGNED_OR_FUTURE_USE, mUnassigned.getProductName());
    }
}
