package com.example.imageapptest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.homeFragment, R.id.aboutFragment).build();

        NavController navController = Navigation.findNavController(this, R.id.fragment);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // TODO: Create App to get images from NASA servers.
        // TODO: / Android Support SDK / AndroidX (support Android SDK 21+)


//        Android Support SDK / AndroidX (support Android SDK 21+)
//        • Retrofit
//        • RecyclerView
//        • ButterKnife (in case that you don't use MVVM with Data Binding / View Binding or Kotlin extensions)
//        • Passing data between activities/fragment
    }
}