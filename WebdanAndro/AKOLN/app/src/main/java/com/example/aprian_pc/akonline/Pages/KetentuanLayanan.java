package com.example.aprian_pc.akonline.Pages;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.aprian_pc.akonline.R;

public class KetentuanLayanan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ketentuan_layanan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        TextView toolbarText = (TextView)
//                findViewById(R.id.toolbar_text);
//        if(toolbarText!=null && toolbar!=null) {
//            toolbarText.setText("Ketentuan Layanan");
//            setSupportActionBar(toolbar);
//        }
//        ActionBar menu = getSupportActionBar();
//        menu.setDisplayShowHomeEnabled(true);
//        menu.setDisplayHomeAsUpEnabled(true);
    }
}
