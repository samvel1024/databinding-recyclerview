package com.samvel1024.databindingrv;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;


/**
 * @author Samvel Abrahamyan
 */
public class BindingHolder<VDB extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private VDB binding;

    public BindingHolder(VDB binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public VDB getBinding() {
        return binding;
    }
}
