package com.shadow.recyclercarousel;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {

    private List<Integer> items;


    public ItemAdapter(List<Integer> allItems) {
        items = allItems;
    }


    @NonNull
    @Override
    public ItemAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview, viewGroup, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemHolder itemsHolder, int i) {

        if(items.get(i) == -1){
            itemsHolder.container.setClickable(false);
            itemsHolder.container.setVisibility(View.INVISIBLE);
        }else {
            itemsHolder.imageView.setImageBitmap(getBitmapFromResources(itemsHolder.itemView.getContext().getResources(), items.get(i)));
        }

    }

    public static Bitmap getBitmapFromResources(Resources resources, int resImage) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inDither = false;
        options.inSampleSize = 1;
        options.inScaled = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;

        Bitmap srcBmp = BitmapFactory.decodeResource(resources, resImage, options);
        Bitmap dstBmp = null;

            dstBmp = Bitmap.createBitmap(
                    srcBmp,
                    srcBmp.getWidth()/2 - 100,
                    srcBmp.getHeight()/2 - 100,
                    200,
                    200
            );

        return dstBmp;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private ConstraintLayout container;

        private ItemHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            container = itemView.findViewById(R.id.container);


        }
    }

}
