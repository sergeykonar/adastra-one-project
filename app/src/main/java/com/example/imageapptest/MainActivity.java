package com.example.imageapptest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.imageapptest.model.Word;
import com.example.imageapptest.viewmodels.WordViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottomNavigationView) BottomNavigationView bottomNavigationView;
    private WordViewModel wordViewModel;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.homeFragment, R.id.aboutFragment).build();

        NavController navController = Navigation.findNavController(this, R.id.fragment);

        AppBarConfiguration appBarConfiguration2 =
                new AppBarConfiguration.Builder(navController.getGraph()).build();
        Toolbar toolbar = findViewById(R.id.toolbar);



        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        NavigationUI.setupWithNavController(toolbar, navController);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        setSupportActionBar(toolbar);
        wordViewModel = new ViewModelProvider(this).get(WordViewModel.class);
        // TODO: Create App to get word definition servers.
        // TODO: / Android Support SDK / AndroidX (support Android SDK 21+)


//        Android Support SDK / AndroidX (support Android SDK 21+)
//        • Retrofit
//        • RecyclerView
//        • ButterKnife (in case that you don't use MVVM with Data Binding / View Binding or Kotlin extensions)
//        • Passing data between activities/fragment

        

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.clear_all:
                wordViewModel.deleteAll();
                Snackbar.make(bottomNavigationView, "Data deleted", Snackbar.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}