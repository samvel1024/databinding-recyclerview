package com.samvel1024.databindingrv_sample;

import java.util.Arrays;
import java.util.List;

/**
 * @author Samvel Abrahamyan
 */

public class MainViewModel {


    private List<ListItemViewModel> viewModels;

    public MainViewModel(View view){
        viewModels = Arrays.asList(
                new ListItemViewModel(view, "Samvel", "Abrahamyan"),
                new ListItemViewModel(view, "Martin", "Mirakyan"),
                new ListItemViewModel(view, "Torgom", "Frndjibachyan"),
                new ListItemViewModel(view, "Garegin", "Bek-Pirumyan")
        );
    }

    public List<ListItemViewModel> getItemViewModels() {
        return viewModels;
    }


    interface View {
        void onItemClicked(ListItemViewModel item);
    }

}
