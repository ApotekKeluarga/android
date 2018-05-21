package com.example.aprian_pc.akonline.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aprian_pc.akonline.R;

/**
 * Created by Aprian-PC on 27/04/2018.
 */

public class RiwayatFragment extends Fragment {
    public RiwayatFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_riwayat, container, false);
    }
}
