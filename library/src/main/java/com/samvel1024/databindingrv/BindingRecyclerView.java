package com.samvel1024.databindingrv;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.util.List;

/**
 * @author Samvel Abrahamyan
 */

public class BindingRecyclerView extends RecyclerView {

    private List<?> viewModelList;
    @LayoutRes
    private int itemLayoutResId;
    private BindingAdapter<?> bindingAdapter;
    private int bindingVarId;

    public BindingRecyclerView(Context context) {
        this(context, null);
    }

    public BindingRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BindingRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        new Configurer(this, attrs).configure();
    }

    @Override
    public void setAdapter(Adapter adapter) {
        if (!(adapter instanceof BindingAdapter))
            throw new IllegalStateException("BindingRecyclerView operates only on BindingAdapter");
        super.setAdapter(adapter);
        this.bindingAdapter = (BindingAdapter<?>) adapter;
    }

    @Override
    public BindingAdapter<?> getAdapter() {
        return bindingAdapter;
    }

    public void setBindingVarId(int bindingVarId){
        this.bindingVarId = bindingVarId;
    }

    public void setViewModelList(List<?> viewModelList) {
        if (viewModelList == null)
            throw new IllegalArgumentException("viewModelList cannot be null");
        if (this.bindingAdapter == null) {
            this.viewModelList = viewModelList;
            setAdapter(new BindingAdapter<>(itemLayoutResId, new ListItemInitializer(viewModelList, bindingVarId)));
        }
        else this.bindingAdapter.notifyDataSetChanged();
    }

    public void setItemLayoutResId(@LayoutRes int itemLayoutResId) {
        this.itemLayoutResId = itemLayoutResId;
    }


}
