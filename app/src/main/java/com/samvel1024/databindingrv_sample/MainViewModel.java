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
    private final View view;

    public MainViewModel(View view) {
        viewModels = new ArrayList<>(Arrays.asList(
                new ListItemViewModel(view, "Toyota Camry", "34000$"),
                new ListItemViewModel(view, "Honda Civic", "32000$"),
                new ListItemViewModel(view, "BMW M3", "85000$"),
                new ListItemViewModel(view, "Volkswagen Golf", "40000$")
        ));
        this.view = view;
    }

    @Bindable
    public List<ListItemViewModel> getItemViewModels() {
        return viewModels;
    }

    public void onAddItemClicked(){
        viewModels.add(new ListItemViewModel(view, "A new car", "80000$"));
        notifyPropertyChanged(BR.itemViewModels);
    }


    interface View {
        void onItemClicked(ListItemViewModel item);
    }

}
