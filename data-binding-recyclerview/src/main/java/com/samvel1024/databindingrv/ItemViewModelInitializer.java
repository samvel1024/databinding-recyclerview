package com.samvel1024.databindingrv;

import android.databinding.ViewDataBinding;

/**
 * @author Samvel Abrahamyan
 */
public interface ItemViewModelInitializer<VDB extends ViewDataBinding> {

    /**
     * @param position  index of the row
     * @param vdb data binding object on which the subclass is responsible to set binding variables
     */
    void onInitBinding(int position, VDB vdb);

    int getCount();
}


