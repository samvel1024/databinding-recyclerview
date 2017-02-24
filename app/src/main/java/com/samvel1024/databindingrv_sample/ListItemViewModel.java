package com.samvel1024.databindingrv_sample;


import android.util.Log;

/**
 * @author Samvel Abrahamyan
 */

public class ListItemViewModel {

    private final String name;
    private final String price;

    public ListItemViewModel(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public void onBuyButtonClicked() {
        Log.d("ListItemViewModel", "Buying " + name + " for " + price);
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
