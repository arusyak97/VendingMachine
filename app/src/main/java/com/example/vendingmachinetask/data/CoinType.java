package com.example.vendingmachinetask.data;

import static com.example.vendingmachinetask.data.Coins.DIME_DIAMETER_IN_MM;
import static com.example.vendingmachinetask.data.Coins.DIME_WEIGHT_IN_GRAMS;
import static com.example.vendingmachinetask.data.Coins.NICKEL_DIAMETER_IN_MM;
import static com.example.vendingmachinetask.data.Coins.NICKEL_WEIGHT_IN_GRAMS;
import static com.example.vendingmachinetask.data.Coins.PENNY_DIAMETER_IN_MM;
import static com.example.vendingmachinetask.data.Coins.PENNY_WEIGHT_IN_GRAMS;
import static com.example.vendingmachinetask.data.Coins.QUARTER_DIAMETER_IN_MM;
import static com.example.vendingmachinetask.data.Coins.QUARTER_WEIGHT_IN_GRAMS;
import static com.example.vendingmachinetask.data.Coins.UNACCEPTABLE_COIN_DIAMETER_IN_MM;
import static com.example.vendingmachinetask.data.Coins.UNACCEPTABLE_COIN_TYPE;
import static com.example.vendingmachinetask.data.Coins.UNACCEPTABLE_COIN_WEIGHT_IN_GRAMS;

/**
 * Defines coin type for vending machine.
 */
public enum CoinType {
    PENNY(Coins.PENNY, PENNY_WEIGHT_IN_GRAMS, PENNY_DIAMETER_IN_MM),
    NICKEL(Coins.NICKEL, NICKEL_WEIGHT_IN_GRAMS, NICKEL_DIAMETER_IN_MM),
    DIME(Coins.DIME, DIME_WEIGHT_IN_GRAMS, DIME_DIAMETER_IN_MM),
    QUARTER(Coins.QUARTER, QUARTER_WEIGHT_IN_GRAMS, QUARTER_DIAMETER_IN_MM),
    UNASSIGNED_OR_FUTURE_USE(UNACCEPTABLE_COIN_TYPE, UNACCEPTABLE_COIN_WEIGHT_IN_GRAMS, UNACCEPTABLE_COIN_DIAMETER_IN_MM);

    private int mValueInCents;
    private double mWeight;
    private double mDiameter;

    /**
     * Creates and returns {@link ProductType} corresponding to the weight and diameter.
     *
     * @param weight   the weight of the coin
     * @param diameter the diameter of the coin
     * @return the type corresponding to the weight and diameter
     */
    public static CoinType create(Double weight, Double diameter) {
        if (weight == PENNY_WEIGHT_IN_GRAMS && diameter == PENNY_DIAMETER_IN_MM) {
            return PENNY;
        } else if (weight == NICKEL_WEIGHT_IN_GRAMS && diameter == NICKEL_DIAMETER_IN_MM) {
            return NICKEL;
        }
        if (weight == DIME_WEIGHT_IN_GRAMS && diameter == DIME_DIAMETER_IN_MM) {
            return DIME;
        } else if (weight == QUARTER_WEIGHT_IN_GRAMS && diameter == QUARTER_DIAMETER_IN_MM) {
            return QUARTER;
        } else {
            return UNASSIGNED_OR_FUTURE_USE;
        }
    }

    /**
     * Constructor for coins.
     *
     * @param valueInCents the value of the coin in cents
     * @param weight       the weight of the coin in grams
     * @param diameter     the diameter of the coin in millimeters
     */
    CoinType(int valueInCents, double weight, double diameter) {
        mValueInCents = valueInCents;
        mWeight = weight;
        mDiameter = diameter;
    }

    /**
     * Gets the coin value in cents.
     *
     * @return the coin value in cents
     */
    public int getValueInCents() {
        return mValueInCents;
    }

    /**
     * Gets the weight in grams.
     *
     * @return the weight in grams
     */
    public double getWeight() {
        return mWeight;
    }

    /**
     * Gets the diameter in millimeters.
     *
     * @return the diameter in millimeters
     */
    public double getDiameter() {
        return mDiameter;
    }
}
