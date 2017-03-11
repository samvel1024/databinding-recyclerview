package com.samvel1024.databindingrv;

import android.databinding.ViewDataBinding;

import java.util.List;

/**
 * @author Samvel Abrahamyan
 */

public class ListItemInitializer implements ItemViewModelInitializer<ViewDataBinding> {


    private List<?> viewModelList;
    private final int bindingVarId;

    public ListItemInitializer(List<?> viewModelList, int bindingVarId){
        this.viewModelList = viewModelList;
        this.bindingVarId = bindingVarId;
    }

    @Override
    public void onInitBinding(int position, ViewDataBinding binding) {
        binding.setVariable(bindingVarId, viewModelList.get(position));
    }

    @Override
    public int getCount() {
        return viewModelList.size();
    }

    public void setViewModelList(List<?> viewModelList){
        this.viewModelList = viewModelList;
    }

    public List<?> getViewModelList() {
        return viewModelList;
    }
}
