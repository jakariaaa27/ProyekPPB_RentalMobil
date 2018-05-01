package com.example.jakaria.rentalmobil;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by JAKARIA on 30/04/2018.
 */

public class MobilAdapter extends RecyclerView.Adapter<MobileView> {

    private static final int LENGTH = 6;

    private final String[] mPlaces;
    private final String[] mPlaceDesc;
    private final Drawable[] mPlacePictures;

    public MobilAdapter(Context context) {
        Resources resources = context.getResources();
        mPlaces = resources.getStringArray(R.array.hero);
        mPlaceDesc = resources.getStringArray(R.array.hero_desc);
        TypedArray a = resources.obtainTypedArray(R.array.hero_picture);
        mPlacePictures = new Drawable[a.length()];
        for (int i = 0; i < mPlacePictures.length; i++) {
            mPlacePictures[i] = a.getDrawable(i);
        }
        a.recycle();
    }

    @Override
    public MobileView onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MobileView(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(MobileView holder, int position) {
        holder.picture.setImageDrawable(mPlacePictures[position % mPlacePictures.length]);
        holder.name.setText(mPlaces[position % mPlaces.length]);
        holder.description.setText(mPlaceDesc[position % mPlaceDesc.length]);
    }

    @Override
    public int getItemCount() {
        return LENGTH;
    }
}