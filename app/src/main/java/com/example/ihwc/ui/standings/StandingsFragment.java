package com.example.ihwc.ui.standings;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ihwc.R;
import com.example.ihwc.ui.main.SectionsPagerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class StandingsFragment extends Fragment {

    private StandingsViewModel mViewModel;
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(StandingsViewModel.class);
    }

}