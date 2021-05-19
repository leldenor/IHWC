package com.example.ihwc.ui.standings;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ihwc.ui.teamInfo.GamesFragment;
import com.example.ihwc.ui.teamInfo.InfoFragment;
import com.example.ihwc.ui.teamInfo.RosterFragment;

public class PagerAdapter extends FragmentPagerAdapter {
    private Context context;
    final int PAGE_COUNT=2;
    private String titles[]=new String[]{"Group A", "Group B"};

    public PagerAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context=context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        if(position==0){
            fragment=new GroupAFragment();
        }else if(position==1){
            fragment=new GroupBFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
