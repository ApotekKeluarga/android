package com.example.aprian_pc.akonline;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.aprian_pc.akonline.Pages.Cari;
import com.example.aprian_pc.akonline.Pages.Troli;
import com.example.aprian_pc.akonline.Tab.MyAdapter;
import com.example.aprian_pc.akonline.Tab.SlidingTabLayout;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity{

    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    SessionManager sessionManager;
    //    private ViewFlipper viewFlipper;
//    private Animation fadeIn, fadeOut;
    String Titles[] = {"Beranda","Layanan","Riwayat","Pengaturan"};
    int jml = 4 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.icon);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        mViewPager = (ViewPager) findViewById(R.id.vp_tabs);
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), this, Titles, jml));
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.stl_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.white));
        mSlidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.tv_tab);
        mSlidingTabLayout.setViewPager(mViewPager);

//        viewFlipper = (ViewFlipper)findViewById(R.id.flipper);
//        fadeIn = AnimationUtils.loadAnimation(this,R.anim.fade_in);
//        fadeOut = AnimationUtils.loadAnimation(this,R.anim.fade_out);
//        viewFlipper.setInAnimation(fadeIn);
//        viewFlipper.setOutAnimation(fadeOut);
//
//        viewFlipper.setAutoStart(true);
//        viewFlipper.setFlipInterval(5000);
//        viewFlipper.startFlipping();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.cart :
                Intent intent = new Intent(this, Troli.class);
                this.startActivity(intent);
                break;
            case R.id.search :
                Intent intent2 = new Intent(this, Cari.class);
                this.startActivity(intent2);
                break;
        }



        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed(){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Exit")
                .setMessage("Anda yakin ingin keluar Aplikasi ini ?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("Tidak",null);
        android.app.AlertDialog alert = builder.create();
        alert.show();
    }
}
