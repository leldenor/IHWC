package com.example.ihwc.main.standings;



import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ihwc.R;
import com.google.android.material.tabs.TabLayout;

public class StandingsFragment extends Fragment {

    private ViewPager viewPager;
    private View view;

    public StandingsFragment() {
    }

    public static StandingsFragment newInstance() {
        return new StandingsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.standings_fragment, container, false);
        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager(), this.getContext());
        viewPager = view.findViewById(R.id.view_pager_standings);
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabs = view.findViewById(R.id.tabLayoutGroups);
        tabs.setupWithViewPager(viewPager);

        return view;
    }


}