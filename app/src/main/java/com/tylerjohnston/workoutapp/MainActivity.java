package com.tylerjohnston.workoutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;

import com.google.android.material.navigation.NavigationView;
import com.tylerjohnston.workoutapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        binding.materialToolbar.setNavigationOnClickListener((view) -> {

            drawerLayout.openDrawer(GravityCompat.START);

        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((menuItem) -> {


            if (menuItem.getItemId() == R.id.nav_home) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container_view, HomeFragment.class, null)
                        .addToBackStack(null)
                        .commit();
            }

            if (menuItem.getItemId() == R.id.nav_plan) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container_view, PlanFragment.class, null)
                        .addToBackStack(null)
                        .commit();
            }

            if (menuItem.getItemId() == R.id.nav_calendar) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container_view, CalendarFragment.class, null)
                        .addToBackStack(null)
                        .commit();
            }

            if (menuItem.getItemId() == R.id.nav_user_info) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container_view, UserInfoFragment.class, null)
                        .addToBackStack(null)
                        .commit();
            }

            drawerLayout.closeDrawers();
            return true;
        });
    }
}