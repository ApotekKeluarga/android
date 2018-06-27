package com.example.aprian_pc.akonline.Pages;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.aprian_pc.akonline.R;
import com.example.aprian_pc.akonline.Server;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

 public class Daftar extends AppCompatActivity {

    private EditText nm_depan, nm_belakang, no_telp, email, pass, ulangi_pass;
    private Button btn_daftar;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private TextView tvDateResult;
    private Button btDatePicker;
    private RadioGroup jk;
    private ProgressBar loading;
    Server server=new Server();
    private String URLSERVER=server.getURL();
    private static String URL_REGIST ="Android/registerAndroid";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        /**
         * Kita menggunakan format tanggal dd-MM-yyyy
         * jadi nanti tanggal nya akan diformat menjadi
         * misalnya 01-12-2017
         */
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        nm_depan = (EditText) findViewById(R.id.namadepan);
        nm_belakang = (EditText) findViewById(R.id.namabelakang);
        no_telp = (EditText) findViewById(R.id.telepon);
        email = (EditText) findViewById(R.id.email);
        loading = (ProgressBar) findViewById(R.id.loading);
        pass = (EditText) findViewById(R.id.password);
        jk = (RadioGroup) findViewById(R.id.gender_radio_group);
        ulangi_pass = (EditText) findViewById(R.id.ulangpass);
        tvDateResult = (TextView) findViewById(R.id.resulttanggal);
        btDatePicker = (Button) findViewById(R.id.bt_datepicker);
        btn_daftar = (Button) findViewById(R.id.daftar);

        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mNm_depan = nm_depan.getText().toString().trim();
                String mNm_belakang = nm_belakang.getText().toString().trim();
                String mNo_telp = no_telp.getText().toString().trim();
                String mTgl_lahir =tvDateResult.getText().toString().trim();
                String mEmail = email.getText().toString().trim();
                String mPass = pass.getText().toString().trim();
                String mUlangipass = ulangi_pass.getText().toString().trim();
                Integer mJeniskel = jk.getCheckedRadioButtonId();



                if (mNm_depan.isEmpty()){
                    nm_depan.setError("Silahkan isi Nama Depan");
                }else if (mNm_belakang.isEmpty()){
                    nm_belakang.setError("Silahkan isi Nama Belakang");
                }else if (mNo_telp.isEmpty()){
                    no_telp.setError("Silahkan isi No. Telepon");
                }else if(mEmail.isEmpty()){
                    email.setError("Silahkan isi Email");
                }else if (mPass.isEmpty()){
                    pass.setError("Silahkan isi Password");
                }else if (mUlangipass.isEmpty()){
                    ulangi_pass.setError("Silahkan isi Ulangi Password");
                }else {
                    daftar(
                            mNm_depan,
                            mNm_belakang,
                            mNo_telp,
                            mTgl_lahir,
                            mJeniskel,
                            mEmail,
                            mPass,
                            mUlangipass);
                    loading.setVisibility(View.VISIBLE);
                    btn_daftar.setVisibility(View.GONE);
                }

                /*daftar(
                        mNm_depan,
                        mNm_belakang,
                        mNo_telp,
                        mTgl_lahir,
                        mJeniskel,
                        mEmail,
                        mPass,
                        mUlangipass);*/
                openMenuLogin();

            }
        });
        btDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
//                submitForm();
            }
        });
    }

     private void openMenuLogin() {

     }

     private void daftar(final String mNm_depan, final String mNm_belakang, final String mNo_telp, final String mTgl_lahir, final int mJeniskel, final String mEmail, final String mPass, final String mUlangipass){
        loading.setVisibility(View.VISIBLE);
        btn_daftar.setVisibility(View.GONE);

//        final String nm_depan = this.nm_depan.getText().toString().trim();
//        final String nm_belakang = this.nm_belakang.getText().toString().trim();
//        final String no_telp = this.no_telp.getText().toString().trim();
//        final String tgl_lahir = this.tvDateResult.getText().toString().trim();
//        final Integer jeniskel = this.jk.getCheckedRadioButtonId();
//        final RadioButton jeniskel1 = (RadioButton) findViewById(jeniskel);
//        final String email = this.email.getText().toString().trim();
//        final String password = this.pass.getText().toString().trim();
//        final String ulangipass = this.ulangi_pass.getText().toString().trim();

        final RadioButton jeniskel1 = (RadioButton) findViewById(mJeniskel);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLSERVER+URL_REGIST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String kode = jsonObject.getString("kode");

                    if (kode.equals("1")){
                        Toast.makeText(Daftar.this,"Daftar akun berhasil, silahkan login",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Daftar.this, Login.class);
                        Daftar.this.startActivity(intent);
                        finish();
                        loading.setVisibility(View.GONE);

                    }
                    loading.setVisibility(View.GONE);
                    btn_daftar.setVisibility(View.VISIBLE);

                } catch (JSONException e) {
                    Toast.makeText(Daftar.this,"Daftar akun gagal..!"+e.toString(),Toast.LENGTH_SHORT).show();
                    loading.setVisibility(View.GONE);
                    btn_daftar.setVisibility(View.VISIBLE);
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Daftar.this,"Daftar akun gagal..!"+error.toString(),Toast.LENGTH_SHORT).show();
                        loading.setVisibility(View.GONE);
                        btn_daftar.setVisibility(View.VISIBLE);

                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Nm_Depan",mNm_depan);
                params.put("Nm_Belakang",mNm_belakang);
                params.put("No_Telp",mNo_telp);
                params.put("Tgl_Lahir",mTgl_lahir);
                params.put("JK", jeniskel1.getText().toString());
                params.put("Email",mEmail);
                params.put("Pass",mPass);
                params.put("Ulangi_Pass",mUlangipass);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showDateDialog(){

        /**
         * Calendar untuk mendapatkan tanggal sekarang
         */
        Calendar newCalendar = Calendar.getInstance();

        /**
         * Initiate DatePicker dialog
         */
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                /**
                 * Method ini dipanggil saat kita selesai memilih tanggal di DatePicker
                 */

                /**
                 * Set Calendar untuk menampung tanggal yang dipilih
                 */
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                /**
                 * Update TextView dengan tanggal yang kita pilih
                 */
                tvDateResult.setText(""+dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        /**
         * Tampilkan DatePicker dialog
         */
        datePickerDialog.show();
    }
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Daftar.this);
        builder.setTitle("Perhatian")
                .setMessage("Anda yakin ingin keluar ?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Daftar.super.onBackPressed();
                    }
                })
                .setNegativeButton("Tidak",null);
        AlertDialog alert = builder.create();
        alert.show();

    }
}