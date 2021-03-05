package com.example.vendingmachinetask.data;

public class Products {
    public static final String PRODUCT_NAME_COLA = "Cola";
    public static final String PRODUCT_NAME_CHIPS = "Chips";
    public static final String PRODUCT_NAME_CANDY = "Candy";
    public static final String PRODUCT_UNASSIGNED_OR_FUTURE_USE = "";

    public static final int PRICE_IN_CENTS_COLA = 100;
    public static final int PRICE_IN_CENTS_CHIPS = 5;
    public static final int PRICE_IN_CENTS_CANDY = 65;
    public static final int PRICE_IN_CENTS_UNASSIGNED_OR_FUTURE_USE = 0;

    private static int mColaQuantity = 0;
    private static int mChipsQuantity = 0;
    private static int mCandyQuantity = 0;

    /**
     * Constructor for Products.
     *
     * @param colaQuantity  the quantity of cola
     * @param chipsQuantity the quantity of chips
     * @param candyQuantity the quantity of candy
     */
    public Products(int colaQuantity, int chipsQuantity, int candyQuantity) {
        mColaQuantity = colaQuantity;
        mChipsQuantity = chipsQuantity;
        mCandyQuantity = candyQuantity;
    }

    /**
     * Gets cola quantity.
     *
     * @return the cola quantity
     */
    public int getColaQuantity() {
        return mColaQuantity;
    }

    /**
     * Gets chips quantity.
     *
     * @return the chips quantity
     */
    public int getChipsQuantity() {
        return mChipsQuantity;
    }

    /**
     * Gets candy quantity.
     *
     * @return the candy quantity
     */
    public int getCandyQuantity() {
        return mCandyQuantity;
    }

    /**
     * Sets Cola quantity.
     *
     * @param colaQuantity the cola quantity
     */
    public void setColaQuantity(int colaQuantity) {
        mColaQuantity = colaQuantity;
    }

    /**
     * Sets chips quantity.
     *
     * @param chipsQuantity the chips quantity
     */
    public void setChipsQuantity(int chipsQuantity) {
        mChipsQuantity = chipsQuantity;
    }

    /**
     * Sets candy quantity.
     *
     * @param candyQuantity the candy quantity
     */
    public void setCandyQuantity(int candyQuantity) {
        mCandyQuantity = candyQuantity;
    }

    /**
     * Checks whether the product is sold out or not.
     *
     * @param type the product tpe
     * @return whether the product is sold out or not
     */
    public static boolean isSoldOut(ProductType type) {
        switch (type) {
            case COLA:
                return mColaQuantity == 0;
            case CHIPS:
                return mChipsQuantity == 0;
            case CANDY:
                return mCandyQuantity == 0;
            default:
                return true;
        }
    }

    /**
     * Dispenses the product.
     *
     * @param type the product type
     */
    public void dispenseProduct(ProductType type) {
        switch (type) {
            case COLA:
                mColaQuantity--;
                break;
            case CHIPS:
                mChipsQuantity--;
                break;
            case CANDY:
                mCandyQuantity--;
                break;
            default:
                break;
        }
    }
}
