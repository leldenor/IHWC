package com.example.ihwc.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.ihwc.R;
import com.example.ihwc.ui.schedule.ScheduleAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar=findViewById(R.id.gameToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        GuessGamePagerAdapter adapter=new GuessGamePagerAdapter(this);

        ViewPager2 viewPager = findViewById(R.id.guessGame_view_pager);
        viewPager.setAdapter(adapter);
        TabLayout tabs = findViewById(R.id.gameTabs);

        new TabLayoutMediator(tabs, viewPager, (tab, position) -> {
            if(position==0){
            tab.setText("Preliminary Round");}
            else if(position==1){
                tab.setText("Quarterfinals");
            }
            else if(position==2){
                tab.setText("Semifinals");
            }
            else if(position==3){
                tab.setText("Finals");
            }

        }).attach();
    }
}