package com.example.vendingmachinetask.data;

import java.util.stream.IntStream;

public class Coins {
    public static final int PENNY = 1;
    public static final int NICKEL = 5;
    public static final int DIME = 10;
    public static final int QUARTER = 25;
    public static final int UNACCEPTABLE_COIN_TYPE = 0;

    public static final int[] validCoins = {
            NICKEL,
            DIME,
            QUARTER
    };

    public static final int[] invalidCoins = {
            PENNY,
            UNACCEPTABLE_COIN_TYPE
    };

    public static final double PENNY_WEIGHT_IN_GRAMS = 2.5;
    public static final double PENNY_DIAMETER_IN_MM = 19.05;
    public static final double NICKEL_WEIGHT_IN_GRAMS = 5.0;
    public static final double NICKEL_DIAMETER_IN_MM = 21.21;
    public static final double DIME_WEIGHT_IN_GRAMS = 2.268;
    public static final double DIME_DIAMETER_IN_MM = 17.91;
    public static final double QUARTER_WEIGHT_IN_GRAMS = 5.67;
    public static final double QUARTER_DIAMETER_IN_MM = 24.26;
    public static final double UNACCEPTABLE_COIN_WEIGHT_IN_GRAMS = 0.0;
    public static final double UNACCEPTABLE_COIN_DIAMETER_IN_MM = 0.0;

    private int mNickelQuantity = 0;
    private int mDimeQuantity = 0;
    private int mQuarterQuantity = 0;


    /**
     * Constructor for Coins.
     *
     * @param nickelQuantity  the quantity of nickels
     * @param dimeQuantity    the quantity of dimes
     * @param quarterQuantity the quantity of quarters
     */
    public Coins(int nickelQuantity, int dimeQuantity, int quarterQuantity) {
        mNickelQuantity = nickelQuantity;
        mDimeQuantity = dimeQuantity;
        mQuarterQuantity = quarterQuantity;
    }

    /**
     * Gets the quantity of nickels.
     *
     * @return the quantity of nickels
     */
    public int getNickelQuantity() {
        return mNickelQuantity;
    }

    /**
     * Gets the quantity of dimes.
     *
     * @return the quantity of dimes
     */
    public int getDimeQuantity() {
        return mDimeQuantity;
    }

    /**
     * Gets the quantity of quarters.
     *
     * @return the quantity of quarters
     */
    public int getQuarterQuantity() {
        return mQuarterQuantity;
    }

    /**
     * Adds a coin to machine.
     *
     * @param value the value of the coin
     */
    public void add(int value) {
        switch (value) {
            case NICKEL:
                mNickelQuantity++;
                break;
            case DIME:
                mDimeQuantity++;
                break;
            case QUARTER:
                mQuarterQuantity++;
                break;
            default:
                break;
        }
    }

    /**
     * Removes a coin to machine.
     *
     * @param value the value of the coin
     */
    public void remove(int value) {
        switch (value) {
            case NICKEL:
                mNickelQuantity--;
                break;
            case DIME:
                mDimeQuantity--;
                break;
            case QUARTER:
                mQuarterQuantity--;
                break;
            default:
                break;
        }
    }

    /**
     * Checks whether the coin is valid or not.
     *
     * @param coinValue the value of the coin
     * @return whether the coin is valid or not
     */
    public boolean isValid(int coinValue) {
        return IntStream.of(validCoins).anyMatch(x -> x == coinValue);
    }

    /**
     * Makes change.
     */
    public void makeChange(int change) {
        int quarters = change / QUARTER;
        if (quarters != 0 && quarters <= mQuarterQuantity) {
            change = change - quarters * QUARTER;
            mQuarterQuantity -= quarters;
        }

        int dimes = change / DIME;
        if (dimes != 0 && dimes <= mDimeQuantity) {
            change = change - dimes * DIME;
            mDimeQuantity -= dimes;
        }

        int nickels = change / NICKEL;
        if (nickels != 0 && nickels <= mNickelQuantity) {
            change = change - nickels * NICKEL;
            mNickelQuantity -= nickels;
        }

        if (change == 0) {
            System.out.println("Change consists of: Quarters: " + quarters + " Dimes: " + dimes + " Nickels: " + nickels);
        } else {
            System.out.println("Please Exact Change Only");
        }
    }

    /**
     * Rejects a coin.
     */
    public void rejectCoin(int value) {
        System.out.println("Rejected coin: " + value);
    }
}
