package com.example.vendingmachinetask;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vendingmachinetask.data.CoinType;
import com.example.vendingmachinetask.data.Coins;
import com.example.vendingmachinetask.data.ProductType;
import com.example.vendingmachinetask.data.Products;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Coins mCoins;
    private Products mProducts;

    private int mTotalPayment = 0;
    private int mProductPrice = 0;

    private ProductType mSelectedProductType;

    private ArrayList<Integer> mInsertedCoins = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCoins = new Coins(10, 10, 10);
        mProducts = new Products(10, 5, 6);
        System.out.println("INSERT COIN");
    }

    /**
     * Selects a product.
     *
     * @param productName the product name
     */
    public void selectProduct(String productName) {
        System.out.println("Selected Product: " + productName);
        mSelectedProductType = ProductType.create(productName);
        if (Products.isSoldOut(mSelectedProductType)) {
            System.out.println("SOLD OUT");
            return;
        }
        System.out.println("Item price: " + mProductPrice + " Current amount: " + mTotalPayment);
        mProductPrice = mSelectedProductType.getPrice();
    }

    /**
     * Accepts coins.
     *
     * @param weight   the weight of the coin
     * @param diameter the diameter of the coin
     */
    public void acceptCoins(double weight, double diameter) {
        CoinType coinType = CoinType.create(weight, diameter);
        int value = coinType.getValueInCents();

        if (mCoins.isValid(value)) {
            mCoins.add(value);
            mTotalPayment += value;
            mInsertedCoins.add(value);

            if (mTotalPayment == mProductPrice) {
                mProducts.dispenseProduct(mSelectedProductType);
                System.out.println("Thank You!");
                resetAll();
            } else if (mTotalPayment >= mProductPrice) {
                int change = mTotalPayment - mProductPrice;
                mCoins.makeChange(change);
            } else {
                System.out.println("Item price: " + mProductPrice + " Current amount: " + mTotalPayment);
                System.out.println("INSERT COIN");
            }

            System.out.println("Total Payment: " + mTotalPayment);
        } else {
            mCoins.rejectCoin(value);
        }
    }

    /**
     * Returns the coins.
     */
    private void returnCoins() {
        System.out.println("Return coins.");

        mInsertedCoins.forEach(coin -> mCoins.remove(coin));
        mInsertedCoins = new ArrayList<>();

        System.out.println("INSERT COIN");
    }

    /**
     * Resets the display.
     */
    private void resetAll() {
        mTotalPayment = 0;
        mProductPrice = 0;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Please Insert Coin");
            }
        }, 2 * 1000);
    }
}