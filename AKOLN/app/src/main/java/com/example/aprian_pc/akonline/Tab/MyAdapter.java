package com.example.aprian_pc.akonline.Tab;

/**
 * Created by Ujang Wahyu on 24/01/2017.
 */


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.widget.TextView;

import com.example.aprian_pc.akonline.Fragment.HomeFragment;
import com.example.aprian_pc.akonline.Fragment.LayananFragment;
import com.example.aprian_pc.akonline.Fragment.PengaturanFragment;
import com.example.aprian_pc.akonline.Fragment.RiwayatFragment;
import com.example.aprian_pc.akonline.R;

/**
 * Created by Ujang Wahyu on 18/08/2016.
 */

public class MyAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] titles ={"sdads","sadsad","sadsa","asdsad"};
    private CharSequence Titles[];
    int NumbOfTabs;
    private TextView text;
    int[] icon = new int[]{R.drawable.ic_home_white_24dp, R.drawable.ic_headset_mic_white_24dp,R.drawable.ic_history_white_24dp,R.drawable.ic_settings_white_24dp};
    private int heightIcon;

    public MyAdapter(FragmentManager fm, Context c, CharSequence mTitles[], int mNumbOfTabsumb){
        super(fm);
        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
        mContext = c;
        double scale = c.getResources().getDisplayMetrics().density;
        heightIcon=(int)(24*scale+0.5f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag= null;

        if(position ==0){
            frag = new HomeFragment();
        }else if(position == 1){
            frag = new LayananFragment();
        }else if(position == 2){
            frag = new RiwayatFragment();
        }else if(position == 3){
            frag = new PengaturanFragment();
        }

        Bundle b = new Bundle();
        b.putInt("position", position);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    public CharSequence getPageTitle(int position){
        Drawable d = mContext.getResources().getDrawable(icon[position]);
        d.setBounds(0,0,heightIcon,heightIcon);
        ImageSpan is = new ImageSpan(d);

        SpannableString sp = new SpannableString(" ");
        sp.setSpan(is,0,sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sp;
    }

}