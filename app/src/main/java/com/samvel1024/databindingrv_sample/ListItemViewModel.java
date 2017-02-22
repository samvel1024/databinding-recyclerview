package com.samvel1024.databindingrv_sample;


/**
 * @author Samvel Abrahamyan
 */

public class ListItemViewModel {

    private final String name;
    private final String surname;
    private final MainViewModel.View view;

    public ListItemViewModel(MainViewModel.View view, String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.view = view;
    }

    public void onCallButtonClicked(){
        view.onItemClicked(this);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
