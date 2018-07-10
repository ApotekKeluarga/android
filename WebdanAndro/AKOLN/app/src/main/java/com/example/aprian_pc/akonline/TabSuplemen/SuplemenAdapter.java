package com.example.aprian_pc.akonline.TabSuplemen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.aprian_pc.akonline.Pages.DetailObat;
import com.example.aprian_pc.akonline.R;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class SuplemenAdapter extends RecyclerView.Adapter<SuplemenAdapter.MyViewHolder> {

    private Context mContext;
    private List<Suplemen> paketList;
    Locale localeID = new Locale("in","ID");
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail;
        public Button btn_beli;
        public Button btn_detail;


        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            btn_beli = (Button) view.findViewById(R.id.btn_beli);
            btn_detail = (Button) view.findViewById(R.id.btn_detail);
        }
    }


    public SuplemenAdapter(Context mContext, List<Suplemen> paketList) {
        this.mContext = mContext;
        this.paketList = paketList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_obat_herbal, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        Suplemen paket = paketList.get(position);
        holder.title.setText(paket.getName());
        holder.count.setText(formatRupiah.format(paket.getPrice()));
        holder.btn_beli.setText(paket.getBtn1());
        holder.btn_detail.setText(paket.getBtn2());
        // loading paket cover using Glide library
        Glide.with(mContext).load(paket.getThumbnail()).into(holder.thumbnail);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailObat.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return paketList.size();
    }
}