package com.example.monsterincity.ACTIVITY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.monsterincity.R;
import com.example.monsterincity.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav);
        NavController navController = navHostFragment.getNavController();
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();

        MenuItem item;


        BottomNavigationView menu = (BottomNavigationView) findViewById(R.id.nav_view);


        menu.setSelectedItemId(R.id.navigation_map);

        menu.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_shop:
                        navController.navigate(R.id.shopFragment);
                        return true;
                    case R.id.navigation_map:
                        navController.navigate(R.id.mapsFragment);
                        return true;
                    case R.id.navigation_character:
                        navController.navigate(R.id.characterFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }


}