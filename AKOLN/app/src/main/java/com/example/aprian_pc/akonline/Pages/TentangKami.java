package com.example.aprian_pc.akonline.Pages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aprian_pc.akonline.R;

public class TentangKami extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_kami);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
////        setSupportActionBar(toolbar);
//        TextView toolbarText = (TextView)
//                findViewById(R.id.toolbar_text);
//        if(toolbarText!=null && toolbar!=null) {
//            toolbarText.setText("Tentang Kami");
////            setSupportActionBar(toolbar);
//        }
//        ActionBar menu = getSupportActionBar();
//        menu.setDisplayShowHomeEnabled(true);
//        menu.setDisplayHomeAsUpEnabled(true);
    }

    public static class DetailObat extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detail_obat);
        }
    }
}