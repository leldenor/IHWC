package com.example.ihwc.ui.schedule;

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
import android.view.View;
import android.view.ViewGroup;

import com.example.ihwc.R;
import com.example.ihwc.ui.teams.Team;
import com.example.ihwc.ui.teams.TeamAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragment extends Fragment {

    private ScheduleViewModel mViewModel;
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
