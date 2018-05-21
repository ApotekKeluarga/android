package com.example.aprian_pc.akonline;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aprian_pc.akonline.Fragment.HomeFragment;
import com.example.aprian_pc.akonline.R;

public class Logout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
}
