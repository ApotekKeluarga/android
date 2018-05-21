package com.example.aprian_pc.akonline.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aprian_pc.akonline.KonfirmasiPesanan;
import com.example.aprian_pc.akonline.Bantuan;
import com.example.aprian_pc.akonline.R;

/**
 * Created by Aprian-PC on 27/04/2018.
 */

public class LayananFragment extends Fragment {
    public LayananFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_layanan, container, false);
        ListView listview =(ListView) rootView.findViewById(R.id.list);
        final String[] items = new String[] {"Konfirmasi Pesanan", "Bantuan"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,items);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity().getApplicationContext(), items[i], Toast.LENGTH_SHORT).show();
                {
                    switch (i) {
                        case 0:
                            Intent intent = new Intent(LayananFragment.this.getActivity(), KonfirmasiPesanan.class);
                            startActivity(intent);
                            break;
                        case 1:
                            Intent intent2 = new Intent(LayananFragment.this.getActivity(), Bantuan.class);
                            startActivity(intent2);
                            break;
                    }
                }
            }
        });
        return rootView;
    }
}
