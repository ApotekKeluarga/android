package com.example.aprian_pc.akonline.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.aprian_pc.akonline.AlatKesehatan;
import com.example.aprian_pc.akonline.Cari;
import com.example.aprian_pc.akonline.ObatAnak;
import com.example.aprian_pc.akonline.ObatAntibiotik;
import com.example.aprian_pc.akonline.ObatHerbal;
import com.example.aprian_pc.akonline.ObatSuplemen;
import com.example.aprian_pc.akonline.R;
import com.example.aprian_pc.akonline.Resep;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ImageButton b = (ImageButton) rootView.findViewById(R.id.herbal);
        ImageButton c = (ImageButton) rootView.findViewById(R.id.antibiotik);
        ImageButton d = (ImageButton) rootView.findViewById(R.id.suplemen);
        ImageButton e = (ImageButton) rootView.findViewById(R.id.anak);
        ImageButton f = (ImageButton) rootView.findViewById(R.id.kesehatan);
        ImageButton g = (ImageButton) rootView.findViewById(R.id.resep);
        ImageButton h = (ImageButton) rootView.findViewById(R.id.cari);

        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), ObatHerbal.class);
                startActivity(intent);

            }

        });

        c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), ObatAntibiotik.class);
                startActivity(intent);

            }

        });

        d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), ObatSuplemen.class);
                startActivity(intent);

            }

        });

        e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), ObatAnak.class);
                startActivity(intent);

            }

        });

        f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), AlatKesehatan.class);
                startActivity(intent);

            }

        });

        g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), Resep.class);
                startActivity(intent);

            }

        });

        h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeFragment.this.getActivity(), Cari.class);
                startActivity(intent);

            }

        });
        return rootView;

    }

}
