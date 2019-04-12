package com.app.archi.architecture.ui.ui;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.app.archi.architecture.BR;
import com.app.archi.architecture.ui.data.Model.ImageItem;
import com.app.archi.architecture.ui.data.Model.Track;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.stream.Collectors;

public class ListAdapter extends BaseRecyclerViewAdapter {

    private final List<Track> tracks;
    private final int  layoutId;
    Picasso picasso;
    public ListAdapter(List<Track> tracks, int layoutId, Picasso picasso)
    {
        this.tracks=tracks;
        this.layoutId=layoutId;
        this.picasso=picasso;
    }
    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.getListItemBinding().setVariable(BR.picasso,picasso);
        super.onBindViewHolder(holder,position);

    }
    @Override
    protected Object getItemForPosition(int position) {
        return getList().get(position);
    }

    @Override
    protected List getList() {
        return tracks;
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return layoutId;
    }

    @BindingAdapter(value ={"imageUrl","placeHolder","picasso"},requireAll=false)
    public static void setImage(ImageView imageView, List<ImageItem> imageItemList, Drawable placeholder, Picasso picasso){
        if(imageItemList!=null)
        imageItemList.stream().filter(item->(item!=null && item.getText()!=null)).collect(Collectors.toList());
      if(imageItemList!=null && imageItemList.size()==0)
      {
          imageView.setImageDrawable(placeholder);
      }else
      {
           picasso.load(imageItemList.get(2).getText()).placeholder(placeholder).into(imageView);
      }
    }




}
