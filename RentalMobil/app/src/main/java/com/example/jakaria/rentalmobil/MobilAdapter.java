package com.example.jakaria.rentalmobil;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JAKARIA on 30/04/2018.
 */

public class MobilAdapter extends RecyclerView.Adapter<MobilAdapter.MobilViewHolder> implements Filterable {

    private Context mCtx;
    private List<MobileView> mobilList;
    private List<MobileView> mobilListFiltered;

    public MobilAdapter(Context mCtx, List<MobileView> warnetList) {
        this.mCtx = mCtx;
        this.mobilList = warnetList;
        this.mobilListFiltered = warnetList;
    }

    @Override
    public MobilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_mobile_view, parent,false);
        return new MobilViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MobilViewHolder holder, int position) {
        final MobileView Warnet = mobilList.get(position);

        //loading the image
        Glide.with(mCtx)
                .load(Warnet.getGambar())
                .into(holder.imageView);

        holder.tvNama.setText(Warnet.getNama());
        holder.tvDeskripsi.setText(Warnet.getDeskripsi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mCtx,MobileDetail.class);
                i.putExtra("mobil_image",mobilList.get(holder.getAdapterPosition()).getGambar());
                i.putExtra("mobil_title",mobilList.get(holder.getAdapterPosition()).getNama());
                i.putExtra("mobil_desc",mobilList.get(holder.getAdapterPosition()).getDeskripsi());
                mCtx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mobilList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    mobilList = mobilListFiltered;
                } else {
                    List<MobileView> filteredList = new ArrayList<>();
                    for (MobileView row : mobilListFiltered) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getNama().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    mobilList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mobilList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mobilList = (ArrayList<MobileView>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class MobilViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvDeskripsi;
        ImageView imageView;

        public MobilViewHolder(View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.card_title);
            tvDeskripsi = itemView.findViewById(R.id.card_text);
            imageView = itemView.findViewById(R.id.card_image);
        }
    }
}