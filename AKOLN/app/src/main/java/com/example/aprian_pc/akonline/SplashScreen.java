package com.example.aprian_pc.akonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class SplashScreen extends AppCompatActivity {
    private TextView Tv;
    private ImageView Iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Iv = (ImageView) findViewById(R.id.img);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.transition);
        Iv.startAnimation(anim);

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(new Intent(getApplicationContext(), Login.class));
                    finish();
                }
            }
        };
        timer.start();
    }
}


