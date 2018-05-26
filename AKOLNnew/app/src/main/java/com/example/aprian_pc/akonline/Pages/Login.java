package com.example.aprian_pc.akonline.Pages;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aprian_pc.akonline.MainActivity;
import com.example.aprian_pc.akonline.R;

public class Login extends AppCompatActivity {
    EditText username, password;
    Button btnMasuk,btnRegis;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnMasuk = (Button) findViewById(R.id.masuk);
        btnRegis = (Button) findViewById(R.id.daftar);
//        pd = new ProgressDialog(this);
//        pd.setMessage("Verifikasi Login....");
//        pd.show();
//        pd.hide();


        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();
                if (usernameKey.equals("user")&& passwordKey.equals("pass")){

                    Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    Login.this.startActivity(intent);
                    finish();

                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                    builder.setMessage("Username atau Password Anda salah !")
                            .setNegativeButton("Ulangi", null).create().show();
                }

            }
        });
        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenuDaftar();
            }
        });
    }

    private void openMenuDaftar() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
//
//        builder.setTitle("Perhatian")
//                .setMessage("Anda yakin akan mendaftar akun ?")
//                .setNegativeButton("Tidak", null)
//                .setPositiveButton("Ya",null).create().show();
        Intent intent = new Intent(this,Daftar.class);
        startActivity(intent);
    }
    public void onBackPressed(){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Login.this);
        builder.setTitle("Exit")
                .setMessage("Anda yakin ingin keluar Aplikasi ini ?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Login.super.finish();
                    }
                })
                .setNegativeButton("Tidak",null);
        android.app.AlertDialog alert = builder.create();
        alert.show();

    }
}

