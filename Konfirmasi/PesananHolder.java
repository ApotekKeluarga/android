package com.example.aprian_pc.akonline.TabHerbal;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aprian_pc.akonline.R;

public class PesananHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView status, code, btnbeli, btndetail;
    ItemClickListener itemClickListener;

    public PesananHolder(View view) {
        super(view);
        status = (TextView) view.findViewById(R.id.status);
        code = (TextView) view.findViewById(R.id.code);
        btnbeli = (TextView) view.findViewById(R.id.btn_beli);
        btndetail = (TextView) view.findViewById(R.id.btn_detail);

    }

    public void setItemClickListener(ItemClickListener ic) {
        this.itemClickListener = ic;
    }

    public void onClick(View v) {
        this.itemClickListener.OnItemClick(v, getLayoutPosition());
    }
}

