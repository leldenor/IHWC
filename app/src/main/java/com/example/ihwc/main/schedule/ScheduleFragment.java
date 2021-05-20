package com.example.ihwc.main.schedule;

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

public class ScheduleFragment extends Fragment {

    private ViewPager viewPager;
    private View view;


    public ScheduleFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.schedule_fragment, container, false);
        ScheduleAdapter gameAdapter=new ScheduleAdapter(getChildFragmentManager(), this.getActivity());

        viewPager = view.findViewById(R.id.view_pager_schedule);
        viewPager.setAdapter(gameAdapter);
        TabLayout tabs = view.findViewById(R.id.tabLayoutSchedule);
        tabs.setupWithViewPager(viewPager);

        return view;
    }


}
