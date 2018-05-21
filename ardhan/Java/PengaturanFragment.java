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

import com.example.aprian_pc.akonline.Logout;
import com.example.aprian_pc.akonline.ProfilUser;
import com.example.aprian_pc.akonline.R;
import com.example.aprian_pc.akonline.TentangKami;

/**
 * Created by Aprian-PC on 27/04/2018.
 */

public class PengaturanFragment extends Fragment {
    public PengaturanFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_pengaturan, container, false);
        ListView listview =(ListView) rootView.findViewById(R.id.list);
        final String[] items = new String[] {"Profil", "Tentang Kami", "Keluar/Log Out"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Intent intent = new Intent(PengaturanFragment.this.getActivity(), ProfilUser.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(PengaturanFragment.this.getActivity(), TentangKami.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(PengaturanFragment.this.getActivity(), Logout.class);
                        startActivity(intent3);
                }
            }
        });
        return rootView;
    }
}
