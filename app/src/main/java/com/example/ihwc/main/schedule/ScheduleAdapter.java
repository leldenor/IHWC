package com.example.ihwc.main.schedule;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ScheduleAdapter extends FragmentPagerAdapter {

    private Context context;
    final int PAGE_COUNT=4;
    private String titles[]=new String[]{"Preliminary Round", "Quarterfinals", "Semifinals", "Finals"};

    public ScheduleAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return GameFragment.getInstance(position);
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
