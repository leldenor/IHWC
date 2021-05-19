package com.example.ihwc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ihwc.game.FullscreenGameActivity;
import com.example.ihwc.ui.teams.TeamsViewModel;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;


import com.example.ihwc.ui.main.SectionsPagerAdapter;

public class TeamInfoActivity extends AppCompatActivity {

    private ViewPager viewPager;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_info);
        Toolbar toolbar=findViewById(R.id.teamInfoToolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.teamInfoTabs);
        tabs.setupWithViewPager(viewPager);
        bundle=getIntent().getExtras();
        TeamInfoViewModel viewModel=new ViewModelProvider(this).get(TeamInfoViewModel.class);
        viewModel.setTeam(bundle.getString("Team Item"));
        toolbar.setTitle(bundle.getString("Team Item"));

    }

}