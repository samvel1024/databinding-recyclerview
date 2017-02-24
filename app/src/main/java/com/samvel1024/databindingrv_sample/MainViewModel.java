package com.samvel1024.databindingrv_sample;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Samvel Abrahamyan
 */

public class MainViewModel extends BaseObservable {

    private List<ListItemViewModel> viewModels;

    public MainViewModel() {
        viewModels = new ArrayList<>(Arrays.asList(
                new ListItemViewModel("Toyota Camry", "34000$"),
                new ListItemViewModel("Honda Civic", "32000$"),
                new ListItemViewModel("BMW M3", "85000$"),
                new ListItemViewModel("Volkswagen Golf", "40000$")
        ));
    }

    @Bindable
    public List<ListItemViewModel> getItemViewModels() {
        return viewModels;
    }

    public void onAddItemClicked() {
        viewModels.add(new ListItemViewModel("A new car", "80000$"));
        notifyPropertyChanged(BR.itemViewModels);
    }

}
