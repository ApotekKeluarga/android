package com.example.aprian_pc.akonline.TabHerbal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.aprian_pc.akonline.Pages.DetailObat;
import com.example.aprian_pc.akonline.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BarangAdapter extends RecyclerView.Adapter<BarangHolder> {

    private Context mContext;
    private List<Barang> BarangList;
    String TAG = "Ardhan";
    public ArrayList<Integer> checkedBarang = new ArrayList<Integer>();
    Locale localeID = new Locale("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
    private int mCount = 0;


    public BarangAdapter(Context mContext, List<Barang> BarangList) {
        this.mContext = mContext;
        this.BarangList = BarangList;
    }

    @Override
    public BarangHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_barang, parent, false);

        for(int b=0;b < BarangList.size() ;b++){
            checkedBarang.add(b,0);  //assign 0 by default in each position of ArrayList
        }
        return new BarangHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final BarangHolder holder, int position) {

        Barang barang = BarangList.get(position);
        holder.title.setText(barang.getName());
        holder.count.setText(formatRupiah.format(barang.getPrice()));
        holder.btn_beli.setText(barang.getBtn1());
        holder.btn_detail.setText(barang.getBtn2());
        holder.mShowCount.setText(String.valueOf(barang.getPesanan()));

        // loading barang cover using Glide library
        Glide.with(mContext).load(barang.getThumbnail()).into(holder.thumbnail);

        holder.btn_beli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                if (holder.mShowCount != null) {
                    holder.mShowCount.setText(String.valueOf(mCount));
                }
            }
        });


        holder.btn_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCount != 0) {
                    mCount--;
                    holder.mShowCount.setText(String.valueOf(mCount));
                } else {
                    holder.mShowCount.setText(String.valueOf(0));
                }

            }
        });

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void OnItemClick(View v, int pos) {
                CheckBox checkbox = (CheckBox) v;

                if (checkbox.isChecked()) {
                    checkedBarang.set(pos, 1);
                } else if (!checkbox.isChecked()) {
                    checkedBarang.set(pos, 0);
                }
            }
        });

        int currentPosition = position;
        final Barang infoBarang = BarangList.get(position);

        holder.clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(infoBarang);
            }
        });
    }

    private void removeItem(Barang infoBarang) {
        int currPosition = BarangList.indexOf(infoBarang);
        BarangList.remove(currPosition);
        notifyItemRemoved(currPosition);
    }

    @Override
    public int getItemCount() {
        return BarangList.size();
    }
}
