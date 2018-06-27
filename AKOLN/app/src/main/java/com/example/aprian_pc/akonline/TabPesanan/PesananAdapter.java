package com.example.aprian_pc.akonline.TabPesanan;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.aprian_pc.akonline.Pages.KonfirmasiPesanan;
import com.example.aprian_pc.akonline.R;

import java.util.List;

public class PesananAdapter extends RecyclerView.Adapter<PesananHolder> {

    private Context mContext;
    private List<Pesanan> PesananList;

    public PesananAdapter(Context mContext, List<Pesanan> PesananList) {
        this.mContext = mContext;
        this.PesananList = PesananList;
    }

    @Override
    public PesananHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_pesanan, parent, false);

        return new PesananHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PesananHolder holder, int position) {

        Pesanan pesanan = PesananList.get(position);
        holder.status.setText(pesanan.getStatus());
        holder.code.setText(pesanan.getCode());
        holder.btndetail.setText(pesanan.getBtn1());
        holder.btnbeli.setText(pesanan.getBtn2());

        if (holder.status.getText() == "Tersedia") {
            holder.btndetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Pesanan Anda akan kami antar secepatnya", Toast.LENGTH_SHORT).show();
                }
            });

            int currentPosition2 = position;
            final Pesanan infoPesanan = PesananList.get(position);

            holder.btnbeli.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeItem(infoPesanan);
                }
            });
        }
    }
        private void removeItem (Pesanan infoPesanan){
            int currPosition = PesananList.indexOf(infoPesanan);
            PesananList.remove(currPosition);
            notifyItemRemoved(currPosition);

        }

    @Override
    public int getItemCount() {
        return PesananList.size();
    }
}

