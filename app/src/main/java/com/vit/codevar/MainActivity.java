package com.vit.codevar;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.vit.codevar.ui.ConsumablesFragment.ConsumablesFragment;
import com.vit.codevar.ui.HelpFragment.HelpFragment;
import com.vit.codevar.ui.InfoFragment.InfoFragment;
import com.vit.codevar.ui.NotficationFragment.NotificationFragment;
import com.vit.codevar.ui.TimelineFragment.TimelineFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity
{
    private BottomNavigationView navigationBar;
    private TextView fragmentTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getWindow().setStatusBarColor(getApplicationContext().getColor(R.color.background));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        navigationBar = findViewById(R.id.navigationBar);
        fragmentTitle = findViewById(R.id.fragmentTitle);

        getSupportFragmentManager().beginTransaction().replace(R.id.navigationFragment, new TimelineFragment()).commit();

        navigationBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment selectedFragment = null;

                switch (menuItem.getItemId())
                {
                    case R.id.navigation_timeline:
                        selectedFragment = new TimelineFragment();
                        fragmentTitle.setText(R.string.timelineTitle);
                        break;

                    case R.id.navigation_consumables:
                        selectedFragment = new ConsumablesFragment();
                        fragmentTitle.setText(R.string.consumablesTitle);
                        break;

                    case R.id.navigation_notifications:
                        selectedFragment = new NotificationFragment();
                        fragmentTitle.setText(R.string.notificationsTitle);
                        break;

                    case R.id.navigation_help:
                        selectedFragment = new HelpFragment();
                        fragmentTitle.setText(R.string.helpTitle);
                        break;

                    case R.id.navigation_info:
                        selectedFragment = new InfoFragment();
                        fragmentTitle.setText(R.string.informationTitle);
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.navigationFragment, selectedFragment).commit();

                return true;
            }
        });
    }
}