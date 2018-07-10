package com.example.aprian_pc.akonline.Pages;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.aprian_pc.akonline.R;
import com.example.aprian_pc.akonline.SessionManager;

import java.util.HashMap;

public class ProfilUser extends AppCompatActivity {
    private TextView nm_depan, nm_belakang, no_telp, tgl_lahir, jeniskel, email;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_user);

        sessionManager = new SessionManager(this);

        nm_depan = findViewById(R.id.label_depan);
        nm_belakang = findViewById(R.id.label_belakang);
        no_telp = findViewById(R.id.label_telepon);
        tgl_lahir = findViewById(R.id.label_tanggal);
        jeniskel = findViewById(R.id.label_jenis);
        email = findViewById(R.id.label_surel);

        HashMap<String, String> user =sessionManager.getUserDetail();
        String mNama = String.valueOf(user.get(sessionManager.nama));
        String mNama2 = user.get(sessionManager.nama2);
        String mNo_telp = user.get(sessionManager.no_telp);
        String mTgl_lahir = user.get(sessionManager.tgl_lahir);
        String mJeniskel = user.get(sessionManager.jeniskel);
        String mEmail = user.get(sessionManager.email);

        nm_depan.setText(mNama);
        nm_belakang.setText(mNama2);
        no_telp.setText(mNo_telp);
        tgl_lahir.setText(mTgl_lahir);
        jeniskel.setText(mJeniskel);
        email.setText(mEmail);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
////        setSupportActionBar(toolbar);
//        TextView toolbarText = (TextView)
//                findViewById(R.id.toolbar_text);
//        if(toolbarText!=null && toolbar!=null) {
//            toolbarText.setText("Profil");
////            setSupportActionBar(toolbar);
//        }
//        ActionBar menu = getSupportActionBar();
//        menu.setDisplayShowHomeEnabled(true);
//        menu.setDisplayHomeAsUpEnabled(true);
    }
}
