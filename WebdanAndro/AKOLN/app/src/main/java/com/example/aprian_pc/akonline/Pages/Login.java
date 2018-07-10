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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.aprian_pc.akonline.MainActivity;
import com.example.aprian_pc.akonline.R;
import com.example.aprian_pc.akonline.Server;
import com.example.aprian_pc.akonline.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    private EditText email, password;
    private Button btnMasuk;
    private TextView btnRegis;
    private ProgressBar loading;
    SessionManager sessionManager;
    Server server=new Server();
    private String URLSERVER=server.getURL();
    private static String URL_LOGIN ="Android/loginAndroid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(this);
        if (sessionManager.isLoggin()){
            Intent intent= new Intent(Login.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        //sessionManager.checkLogin();

        email = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnMasuk = (Button) findViewById(R.id.masuk);
        btnRegis = (TextView) findViewById(R.id.daftar);
        loading = (ProgressBar) findViewById(R.id.loading);
//        pd = new ProgressDialog(this);
//        pd.setMessage("Verifikasi Login....");
//        pd.show();
//        pd.hide();



        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail = email.getText().toString().trim();
                String mPass = password.getText().toString().trim();

                if (!mEmail.isEmpty() || !mPass.isEmpty()) {
                    login(mEmail, mPass);
                } else {
                    email.setError("Please insert email");
                    password.setError("Please insert password");
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

    private void login(final String email, final String password) {
        loading.setVisibility(View.VISIBLE);
        btnMasuk.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLSERVER+URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String kode = jsonObject.getString("kode");

                    if (kode.equals("1")){
                        JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                        String kd_user = jsonObject1.getString("kd_user").trim();
                        String nama = jsonObject1.getString("nama").trim();
                        String nama2 = jsonObject1.getString("nama2").trim();
                        String no_telp = jsonObject1.getString("no_telp").trim();
                        String tgl_lahir = jsonObject1.getString("tgl_lahir").trim();
                        String jeniskel = jsonObject1.getString("jeniskel").trim();
                        String email = jsonObject1.getString("email").trim();


                        sessionManager.createSession(kd_user,nama,nama2,no_telp,tgl_lahir,jeniskel,email);

                        Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        Login.this.startActivity(intent);
                        finish();
                        loading.setVisibility(View.GONE);
                    }else {
                        loading.setVisibility(View.GONE);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                        builder.setMessage("Username atau Password Anda salah !")
                              .setNegativeButton("Ulangi", null).create().show();
                    }
                    btnMasuk.setVisibility(View.VISIBLE);
                } catch (JSONException e) {
                    e.printStackTrace();
                    loading.setVisibility(View.GONE);
                    btnMasuk.setVisibility(View.VISIBLE);
                    Toast.makeText(Login.this,"Error"+ e.toString(),Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.setVisibility(View.GONE);
                btnMasuk.setVisibility(View.VISIBLE);
                Toast.makeText(Login.this,"Error"+ error.toString(),Toast.LENGTH_SHORT).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Email",email);
                params.put("Pass",password);
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


//                String usernameKey = email.getText().toString();
//                String passwordKey = password.getText().toString();
//                if (usernameKey.equals("user")&& passwordKey.equals("pass")){
//
//
//
//                }else {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
//                    builder.setMessage("Username atau Password Anda salah !")
//                            .setNegativeButton("Ulangi", null).create().show();
//                }



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

