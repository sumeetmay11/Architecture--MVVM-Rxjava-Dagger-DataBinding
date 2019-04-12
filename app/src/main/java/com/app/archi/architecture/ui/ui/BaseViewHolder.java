package com.app.archi.architecture.ui.ui;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.app.archi.architecture.BR;

public  class BaseViewHolder<T,V extends ViewDataBinding> extends RecyclerView.ViewHolder{
    private V listItemBinding;
    private T dataItem;
    private BaseViewHolder(View itemView) {
        super(itemView);
    }

    public BaseViewHolder(V listItemBinding)
    {
        super(listItemBinding.getRoot());
        this.listItemBinding=listItemBinding;
    }

    public void setModel(T dataItem)
    {
      listItemBinding.setVariable(BR.obj,dataItem);
      listItemBinding.executePendingBindings();
    }

    public V getListItemBinding() {
        return listItemBinding;
    }


}
