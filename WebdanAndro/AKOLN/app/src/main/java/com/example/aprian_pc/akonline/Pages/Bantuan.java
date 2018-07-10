package com.example.aprian_pc.akonline.Pages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.aprian_pc.akonline.R;

public class Bantuan extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan);

        // Inflate the layout for this fragment);
        ListView listview = (ListView) findViewById(R.id.list2);
        final String[] items = new String[] {"Ketentuan Layanan", "Ketentuan Penggunaan", "Ketentuan Transaksi"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent intent = new Intent(Bantuan.this, KetentuanLayanan.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(Bantuan.this, KetentuanPenggunaan.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(Bantuan.this, KetentuanTransaksi.class);
                        startActivity(intent3);
                        break;
                }
            }
        });
    }
}
