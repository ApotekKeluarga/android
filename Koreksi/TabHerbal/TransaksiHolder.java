package com.example.aprian_pc.akonline.TabHerbal;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aprian_pc.akonline.R;

public class TransaksiHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView title, count, mShowCount, date, code;
    public ImageView clear, thumbnail;
    public Button delete;
    public CheckBox checkbox;

    ItemClickListener itemClickListener;

    public TransaksiHolder(View view) {
        super(view);
        title = (TextView) view.findViewById(R.id.title);
        count = (TextView) view.findViewById(R.id.count);
        thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        mShowCount = (TextView) view.findViewById(R.id.jumlahpesanan);
        date = (TextView) view.findViewById(R.id.date);
        code = (TextView) view.findViewById(R.id.code);
        checkbox = (CheckBox) view.findViewById(R.id.checkbox);
        clear = (ImageView) view.findViewById(R.id.clear);

        checkbox.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener ic) {
        this.itemClickListener = ic;
    }

    public void onClick(View v) {
        this.itemClickListener.OnItemClick(v, getLayoutPosition());
    }
}
