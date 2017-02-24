package com.samvel1024.databindingrv_sample;


/**
 * @author Samvel Abrahamyan
 */

public class ListItemViewModel {

    private final String name;
    private final String price;
    private final MainViewModel.View view;

    public ListItemViewModel(MainViewModel.View view, String name, String price) {
        this.name = name;
        this.price = price;
        this.view = view;
    }

    public void onBuyButtonClicked(){
        view.onItemClicked(this);
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
