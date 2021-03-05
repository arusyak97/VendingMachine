package com.example.vendingmachinetask;

import com.example.vendingmachinetask.data.Products;

import org.junit.Test;

import static com.example.vendingmachinetask.data.ProductType.CANDY;
import static com.example.vendingmachinetask.data.ProductType.CHIPS;
import static com.example.vendingmachinetask.data.ProductType.COLA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class ProductsUnitTest {
    @Test
    public void testGetColaQuantity() {
        Products products = new Products(11, 12, 13);
        assertEquals(11, products.getColaQuantity());
    }

    @Test
    public void testGetChipsQuantity() {
        Products products = new Products(11, 12, 13);
        assertEquals(12, products.getChipsQuantity());
    }

    @Test
    public void testGetCandyQuantity() {
        Products products = new Products(11, 12, 13);
        assertEquals(13, products.getCandyQuantity());
    }

    @Test
    public void testSetColaQuantity() {
        Products products = new Products(1, 2, 3);
        products.setColaQuantity(6);
        assertEquals(6, products.getColaQuantity());
    }

    @Test
    public void testSetChipsQuantity() {
        Products products = new Products(1, 2, 3);
        products.setChipsQuantity(7);
        assertEquals(7, products.getChipsQuantity());
    }

    @Test
    public void testSetCandyQuantity() {
        Products products = new Products(1, 2, 3);
        products.setCandyQuantity(8);
        assertEquals(8, products.getCandyQuantity());
    }

    @Test
    public void testIsSoldOutCola() {
        Products products = new Products(1, 2, 3);
        products.setColaQuantity(0);
        assertTrue(Products.isSoldOut(COLA));
    }

    @Test
    public void testIsSoldOutChips() {
        Products products = new Products(1, 2, 3);
        products.setChipsQuantity(0);
        assertTrue(Products.isSoldOut(CHIPS));
    }

    @Test
    public void testIsSoldOutCandy() {
        Products products = new Products(1, 2, 3);
        products.setCandyQuantity(0);
        assertTrue(Products.isSoldOut(CANDY));
    }

    @Test
    public void testDispenseProductCola() {
        Products product = new Products(4, 30, 60);
        product.dispenseProduct(COLA);
        assertSame(3, product.getColaQuantity());
    }

    @Test
    public void testDispenseProductChips() {
        Products product = new Products(4, 30, 60);
        product.dispenseProduct(CHIPS);
        assertSame(29, product.getChipsQuantity());
    }

    @Test
    public void testDispenseProductCandy() {
        Products product = new Products(4, 30, 60);
        product.dispenseProduct(CANDY);
        assertSame(59, product.getCandyQuantity());
    }
}
