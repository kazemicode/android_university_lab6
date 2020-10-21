package com.codepath.nytimes;

import android.location.GpsSatellite;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.codepath.nytimes.ui.home.HomeFragment;
import com.codepath.nytimes.ui.settings.SettingsFragment;
import com.codepath.nytimes.ui.books.BestSellerBooksFragment;
import com.codepath.nytimes.ui.search.ArticleResultFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private static String HOME_TAG = "home";
    private static String BOOKS_TAG = "books";
    private static String ARTICLES_TAG = "articles";
    private static String SETTINGS_TAG = "settings";
    private static String SELECTED_VALUE_ID_KEY;
    HomeFragment homeFragment = HomeFragment.newInstance();
    ArticleResultFragment articleResultFragment = ArticleResultFragment.newInstance();
    BestSellerBooksFragment bestSellerBooksFragment = BestSellerBooksFragment.newInstance();
    SettingsFragment settingsFragment = SettingsFragment.newInstance();
    BottomNavigationView navView;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navView = findViewById(R.id.bottom_navigation);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        articleResultFragment = (ArticleResultFragment) supportFragmentManager.findFragmentByTag(ARTICLES_TAG);
        if (articleResultFragment == null) {
            articleResultFragment = ArticleResultFragment.newInstance();
        }
        bestSellerBooksFragment = (BestSellerBooksFragment) supportFragmentManager.findFragmentByTag(BOOKS_TAG);
        if (bestSellerBooksFragment == null) {
            bestSellerBooksFragment = BestSellerBooksFragment.newInstance();
        }
        homeFragment = (HomeFragment) supportFragmentManager.findFragmentByTag(HOME_TAG);
        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance();
        }
        settingsFragment = (SettingsFragment) supportFragmentManager.findFragmentByTag(SETTINGS_TAG);
        if (settingsFragment == null) {
            settingsFragment = SettingsFragment.newInstance();
        }
     

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()) {
                    case R.id.home: {
                        SELECTED_VALUE_ID_KEY = HOME_TAG;
                        ft.replace(R.id.content, homeFragment, HOME_TAG);
                        break;
                    }
                    case R.id.nav_search: {
                        SELECTED_VALUE_ID_KEY = ARTICLES_TAG;
                        ft.replace(R.id.content, articleResultFragment, ARTICLES_TAG);
                        break;
                    }
                    case R.id.nav_books: {
                        SELECTED_VALUE_ID_KEY = BOOKS_TAG;
                        ft.replace(R.id.content, bestSellerBooksFragment, BOOKS_TAG);
                        break;
                    }
                    case R.id.nav_settings: {
                        SELECTED_VALUE_ID_KEY = SETTINGS_TAG;
                        ft.replace(R.id.content, settingsFragment, SETTINGS_TAG);
                        break;
                    }

                }
                ft.commit();
                return true;
            }
        });

        if (savedInstanceState != null) {
            int selected_bottom_item = savedInstanceState.getInt(SELECTED_VALUE_ID_KEY);
            navView.setSelectedItemId(selected_bottom_item);
        } else {
            navView.setSelectedItemId(R.id.home);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Save custom values into the bundle
        savedInstanceState.putInt(SELECTED_VALUE_ID_KEY, navView.getSelectedItemId());
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

}
