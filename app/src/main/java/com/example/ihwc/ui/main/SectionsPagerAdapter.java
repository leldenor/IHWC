package com.example.ihwc.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ihwc.R;
import com.example.ihwc.ui.teamInfo.GamesFragment;
import com.example.ihwc.ui.teamInfo.InfoFragment;
import com.example.ihwc.ui.teamInfo.RosterFragment;


public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        if(position==0){
            fragment=new InfoFragment();
        }else if(position==1){
            fragment=new RosterFragment();
        }else if(position==2){
            fragment=new GamesFragment();
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Info";
        }else if(position==1){
            return "Roster";
        }else if(position==2){
            return "Games";
        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}