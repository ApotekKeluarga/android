package com.example.aprian_pc.akonline;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.aprian_pc.akonline.Pages.Login;
import com.example.aprian_pc.akonline.MainActivity;

import java.util.HashMap;

public class SessionManager {
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "LOGIN";
    private static final String LOGIN = "IS_LOGIN";
    public static final String nama = "nama";
    public static final String nama2 = "nama2";
    public static final String no_telp = "no_telp";
    public static final String tgl_lahir = "tgl_lahir";
    public static final String kd_user = "kd_user";
    public static final String jeniskel = "jeniskel";
    public static final String email = "email";


    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences =context.getSharedPreferences( PREF_NAME, PRIVATE_MODE );
        editor = sharedPreferences.edit();

    }

    public void createSession(String kd_user,String nm_depan,String nm_belakang, String no_telpon, String tanggal_lahir, String jenis_kelamin,String Email){
        editor.putBoolean(LOGIN, true);
        editor.putString( kd_user, kd_user );
        editor.putString( nama, nm_depan );
        editor.putString( nama2, nm_belakang );
        editor.putString( no_telp, no_telpon );
        editor.putString( tgl_lahir, tanggal_lahir );
        editor.putString( jeniskel, jenis_kelamin );
        editor.putString( email, Email );
        editor.apply();
    }

    public boolean isLoggin(){
        return sharedPreferences.getBoolean( LOGIN, false );
    }

    public void checkLogin(){
        if (!this.isLoggin()){
            Intent intent = new Intent( context, Login.class );
            context.startActivity( intent );
            ((MainActivity) context).finish();
        }
    }

    public HashMap<String, String> getUserDetail(){
        HashMap<String, String> user = new HashMap<>(  );
        user.put( kd_user, sharedPreferences.getString( kd_user, null ) );
        user.put( nama, sharedPreferences.getString( nama, null ) );
        user.put( nama2, sharedPreferences.getString( nama2, null ) );
        user.put( no_telp, sharedPreferences.getString( no_telp, null ) );
        user.put( tgl_lahir, sharedPreferences.getString( tgl_lahir, null ) );
        user.put( jeniskel, sharedPreferences.getString( jeniskel, null ) );
        user.put( email, sharedPreferences.getString( email, null ) );
        return user;
    }

    public void logout(){
        editor.clear();
        editor.commit();
        Intent intent = new Intent( context, Login.class );
        context.startActivity( intent );
        ((MainActivity) context).finish();

    }
}