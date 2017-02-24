package com.samvel1024.databindingrv;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * @author Samvel Abrahamyan
 */

public class BindingAdapter<VDB extends ViewDataBinding> extends RecyclerView.Adapter<BindingHolder<VDB>> {

    private ItemViewModelInitializer<VDB> vmProvider;
    private int layoutResId;

    public BindingAdapter(@LayoutRes int layoutResId, ItemViewModelInitializer<VDB> itemInitializer) {
        this.vmProvider = itemInitializer;
        this.layoutResId = layoutResId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public BindingHolder<VDB> onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding dataBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                layoutResId,
                parent,
                false
        );
        return new BindingHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(BindingHolder<VDB> holder, int position) {
        vmProvider.onInitBinding(position, holder.getBinding());
    }

    @Override
    public int getItemCount() {
        return vmProvider.getCount();
    }


}
