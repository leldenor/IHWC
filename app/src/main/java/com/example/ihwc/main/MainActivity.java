package com.example.ihwc.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.ihwc.R;
import com.example.ihwc.game.FullscreenGameActivity;
import com.example.ihwc.main.schedule.ScheduleFragment;
import com.example.ihwc.main.standings.StandingsFragment;
import com.example.ihwc.main.statistics.StatisticsFragment;

import com.example.ihwc.main.teams.TeamsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView navView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navView = findViewById(R.id.nav_view);

        setFragment(new ScheduleFragment());
        frameLayout=findViewById(R.id.frameLayoutId);
        Toolbar toolbar=findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);
         navView.setOnNavigationItemSelectedListener(item -> {

             if(item.getItemId()==R.id.navigation_schedule)
             {
                 setFragment(new ScheduleFragment());
                 return true;
             }else if(item.getItemId()==R.id.navigation_statistics)
             {
                 setFragment(new StatisticsFragment());
                 return true;
             }else if(item.getItemId()==R.id.navigation_standings)
             {
                 setFragment(new StandingsFragment());
                 return true;
             }else if(item.getItemId()==R.id.navigation_teams)
             {
                 setFragment(new TeamsFragment());
                 return true;
             }


             return false;
         });



    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar_nav_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.game){
            Intent intent = new Intent(MainActivity.this, FullscreenGameActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

    private void setFragment(Fragment fr) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutId, fr);
        fragmentTransaction.commit();

    }

}