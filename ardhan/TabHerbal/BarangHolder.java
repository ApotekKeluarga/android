package com.example.aprian_pc.akonline.TabHerbal;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aprian_pc.akonline.R;

public class BarangHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView title, count, mShowCount;
    public ImageView thumbnail;
    public Button btn_beli;
    public Button btn_detail, delete;
    public CheckBox checkbox;

    ItemClickListener itemClickListener;

    public BarangHolder(View view) {
        super(view);
        title = (TextView) view.findViewById(R.id.title);
        count = (TextView) view.findViewById(R.id.count);
        thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        btn_beli = (Button) view.findViewById(R.id.btn_beli);
        btn_detail = (Button) view.findViewById(R.id.btn_detail);
        mShowCount = (TextView) view.findViewById(R.id.jumlahpesanan);
        delete = (Button) view.findViewById(R.id.delete);
        checkbox = (CheckBox) view.findViewById(R.id.checkbox);

        checkbox.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener ic) {
        this.itemClickListener = ic;
    }

    public void onClick(View v) {
        this.itemClickListener.OnItemClick(v, getLayoutPosition());
    }
}
