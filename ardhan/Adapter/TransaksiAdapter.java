package com.example.aprian_pc.akonline.TabHerbal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.aprian_pc.akonline.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TransaksiAdapter extends RecyclerView.Adapter<TransaksiHolder> {

    private Context mContext;
    private List<Transaksi> TransaksiList;
    public ArrayList<Transaksi> checkedTransaksi = new ArrayList<>();
    Locale localeID = new Locale("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
    private int mCount = 0;


    public TransaksiAdapter(Context mContext, List<Transaksi> TransaksiList) {
        this.mContext = mContext;
        this.TransaksiList = TransaksiList;
    }

    @Override
    public TransaksiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_transaksi, parent, false);
        return new TransaksiHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final TransaksiHolder holder, int position) {

        Transaksi transaksi = TransaksiList.get(position);
        holder.title.setText(transaksi.getName());
        holder.count.setText(formatRupiah.format(transaksi.getPrice()));
        holder.mShowCount.setText(String.valueOf(transaksi.getPesanan()));
        holder.date.setText(transaksi.getDate());
        holder.code.setText(transaksi.getCode());

        // loading transaksi cover using Glide library
        Glide.with(mContext).load(transaksi.getThumbnail()).into(holder.thumbnail);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void OnItemClick(View v, int pos) {
                CheckBox checkbox = (CheckBox) v;

                if (checkbox.isChecked()) {
                    checkedTransaksi.add(TransaksiList.get(pos));
                } else if (!checkbox.isChecked()) {
                    checkedTransaksi.remove(TransaksiList.get(pos));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return TransaksiList.size();
    }
}
