package com.example.vendingmachinetask;

import com.example.vendingmachinetask.data.CoinType;
import com.example.vendingmachinetask.data.Coins;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinTypeTest {
    private CoinType mPenny = CoinType.create(Coins.PENNY_WEIGHT_IN_GRAMS, Coins.PENNY_DIAMETER_IN_MM);
    private CoinType mNickel = CoinType.create(Coins.NICKEL_WEIGHT_IN_GRAMS, Coins.NICKEL_DIAMETER_IN_MM);
    private CoinType mDime = CoinType.create(Coins.DIME_WEIGHT_IN_GRAMS, Coins.DIME_DIAMETER_IN_MM);
    private CoinType mQuarter = CoinType.create(Coins.QUARTER_WEIGHT_IN_GRAMS, Coins.QUARTER_DIAMETER_IN_MM);
    private CoinType mUnassigned = CoinType.create(Coins.UNACCEPTABLE_COIN_WEIGHT_IN_GRAMS, Coins.UNACCEPTABLE_COIN_DIAMETER_IN_MM);
    private double mDelta = 0.001;

    @Test
    public void testGetValueInCentsPenny() {
        assertEquals(Coins.PENNY, mPenny.getValueInCents());
    }

    @Test
    public void testGetValueInCentsNickel() {
        assertEquals(Coins.NICKEL, mNickel.getValueInCents());
    }

    @Test
    public void testGetValueInCentsDime() {
        assertEquals(Coins.DIME, mDime.getValueInCents());
    }

    @Test
    public void testGetValueInCentsQuarter() {
        assertEquals(Coins.QUARTER, mQuarter.getValueInCents());
    }

    @Test
    public void testGetValueInCentsUnassigned() {
        assertEquals(Coins.UNACCEPTABLE_COIN_TYPE, mUnassigned.getValueInCents());
    }

    @Test
    public void testGetWeightPenny() {
        assertEquals(Coins.PENNY_WEIGHT_IN_GRAMS, mPenny.getWeight(), mDelta);
    }

    @Test
    public void testGetWeightNickel() {
        assertEquals(Coins.NICKEL_WEIGHT_IN_GRAMS, mNickel.getWeight(), mDelta);
    }

    @Test
    public void testGetWeightDime() {
        assertEquals(Coins.DIME_WEIGHT_IN_GRAMS, mDime.getWeight(), mDelta);
    }

    @Test
    public void testGetWeightQuarter() {
        assertEquals(Coins.QUARTER_WEIGHT_IN_GRAMS, mQuarter.getWeight(), mDelta);
    }

    @Test
    public void testGetWeightUnassigned() {
        assertEquals(Coins.UNACCEPTABLE_COIN_WEIGHT_IN_GRAMS, mUnassigned.getWeight(), mDelta);
    }

    @Test
    public void testGetDiameterPenny() {
        assertEquals(Coins.PENNY_DIAMETER_IN_MM, mPenny.getDiameter(), mDelta);
    }

    @Test
    public void testGetDiameterNickel() {
        assertEquals(Coins.NICKEL_DIAMETER_IN_MM, mNickel.getDiameter(), mDelta);
    }

    @Test
    public void testGetDiameterDime() {
        assertEquals(Coins.DIME_DIAMETER_IN_MM, mDime.getDiameter(), mDelta);
    }

    @Test
    public void testGetDiameterQuarter() {
        assertEquals(Coins.QUARTER_DIAMETER_IN_MM, mQuarter.getDiameter(), mDelta);
    }

    @Test
    public void testGetDiameterUnassigned() {
        assertEquals(Coins.UNACCEPTABLE_COIN_DIAMETER_IN_MM, mUnassigned.getDiameter(), mDelta);
    }
}
