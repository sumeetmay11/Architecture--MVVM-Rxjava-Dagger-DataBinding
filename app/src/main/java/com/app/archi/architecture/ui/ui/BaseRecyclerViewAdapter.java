package com.app.archi.architecture.ui.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public abstract class BaseRecyclerViewAdapter<T,V> extends RecyclerView.Adapter<BaseViewHolder> {
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        ViewDataBinding viewDataBinding= DataBindingUtil.inflate(layoutInflater
                ,viewType,parent,false);
        return new NormalHolder(viewDataBinding);
    }

    @Override
    public int getItemCount() {
        return getList().size();
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
         holder.setModel(getItemForPosition(position));
    }

    protected abstract T getItemForPosition(int position);
    protected abstract List getList();
    protected abstract int getLayoutIdForPosition(int position);

    public  class NormalHolder extends BaseViewHolder{

        public NormalHolder(ViewDataBinding listItemBinding) {
            super(listItemBinding);
        }

    }
    public void refreshList()
    {
        this.notifyDataSetChanged();
    }

    public void addListItem(T item)
    {
        int position=getList().indexOf(item);
        notifyItemInserted(position);
    }
    public void deleteListItem(T item)
    {
        int position=getList().indexOf(item);
        notifyItemRemoved(position);
    }

}
