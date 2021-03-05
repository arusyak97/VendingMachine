package com.example.vendingmachinetask;

import com.example.vendingmachinetask.data.Coins;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CoinsUnitTest {
    private final Coins mCoins = new Coins(11, 12, 13);

    @Test
    public void testGetNickelQuantity() {
        assertEquals(11, mCoins.getNickelQuantity());
    }

    @Test
    public void testGetDimeQuantity() {
        assertEquals(12, mCoins.getDimeQuantity());
    }

    @Test
    public void testGetQuarterQuantity() {
        assertEquals(13, mCoins.getQuarterQuantity());
    }

    @Test
    public void testIsValid() {
        assertFalse(mCoins.isValid(Coins.PENNY));
        assertFalse(mCoins.isValid(123));
        assertTrue(mCoins.isValid(Coins.NICKEL));
        assertTrue(mCoins.isValid(Coins.DIME));
        assertTrue(mCoins.isValid(Coins.QUARTER));
    }

    @Test
    public void testAddPenny() {
        Coins coins = new Coins(2, 0, 1);

        coins.add(Coins.PENNY);
        assertEquals(2, coins.getNickelQuantity());
        assertEquals(0, coins.getDimeQuantity());
        assertEquals(1, coins.getQuarterQuantity());
    }

    @Test
    public void testAddNickel() {
        Coins coins = new Coins(2, 0, 1);

        coins.add(Coins.NICKEL);
        assertEquals(3, coins.getNickelQuantity());
        assertEquals(0, coins.getDimeQuantity());
        assertEquals(1, coins.getQuarterQuantity());
    }

    @Test
    public void testAddDime() {
        Coins coins = new Coins(2, 0, 1);

        coins.add(Coins.DIME);
        assertEquals(2, coins.getNickelQuantity());
        assertEquals(1, coins.getDimeQuantity());
        assertEquals(1, coins.getQuarterQuantity());
    }

    @Test
    public void testAddQuarter() {
        Coins coins = new Coins(2, 0, 1);

        coins.add(Coins.QUARTER);
        assertEquals(2, coins.getNickelQuantity());
        assertEquals(0, coins.getDimeQuantity());
        assertEquals(2, coins.getQuarterQuantity());
    }

    @Test
    public void testRemovePenny() {
        Coins coins = new Coins(2, 3, 4);

        coins.remove(Coins.PENNY);
        assertEquals(2, coins.getNickelQuantity());
        assertEquals(3, coins.getDimeQuantity());
        assertEquals(4, coins.getQuarterQuantity());
    }

    @Test
    public void testRemoveNickel() {
        Coins coins = new Coins(2, 3, 4);

        coins.remove(Coins.NICKEL);
        assertEquals(1, coins.getNickelQuantity());
        assertEquals(3, coins.getDimeQuantity());
        assertEquals(4, coins.getQuarterQuantity());
    }

    @Test
    public void testRemoveDime() {
        Coins coins = new Coins(2, 3, 4);

        coins.remove(Coins.DIME);
        assertEquals(2, coins.getNickelQuantity());
        assertEquals(2, coins.getDimeQuantity());
        assertEquals(4, coins.getQuarterQuantity());
    }

    @Test
    public void testRemoveQuarter() {
        Coins coins = new Coins(2, 3, 4);

        coins.remove(Coins.QUARTER);
        assertEquals(2, coins.getNickelQuantity());
        assertEquals(3, coins.getDimeQuantity());
        assertEquals(3, coins.getQuarterQuantity());
    }

    @Test
    public void testMakeChangeQuarters() {
        Coins coins = new Coins(0, 0, 5);
        coins.makeChange(75);

        assertEquals(0, coins.getNickelQuantity());
        assertEquals(0, coins.getDimeQuantity());
        assertEquals(2, coins.getQuarterQuantity());
    }

    @Test
    public void testMakeChangeDimes() {
        Coins coins = new Coins(0, 4, 0);
        coins.makeChange(20);

        assertEquals(0, coins.getNickelQuantity());
        assertEquals(2, coins.getDimeQuantity());
        assertEquals(0, coins.getQuarterQuantity());
    }

    @Test
    public void testMakeChangeNickels() {
        Coins coins = new Coins(10, 0, 0);
        coins.makeChange(20);

        assertEquals(6, coins.getNickelQuantity());
        assertEquals(0, coins.getDimeQuantity());
        assertEquals(0, coins.getQuarterQuantity());
    }


    @Test
    public void testMakeChange() {
        Coins coins = new Coins(10, 10, 10);
        coins.makeChange(65);

        assertEquals(9, coins.getNickelQuantity());
        assertEquals(9, coins.getDimeQuantity());
        assertEquals(8, coins.getQuarterQuantity());
    }
}
