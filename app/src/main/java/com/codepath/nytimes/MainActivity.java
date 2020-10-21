package com.codepath.nytimes;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
    HomeFragment homeFragment = HomeFragment.newInstance();
    ArticleResultFragment articleResultFragment = ArticleResultFragment.newInstance();
    BestSellerBooksFragment bestSellerBooksFragment = BestSellerBooksFragment.newInstance();
    SettingsFragment settingsFragment = SettingsFragment.newInstance();


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.bottom_navigation);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()) {
                    case R.id.home: {
                        ft.replace(R.id.content, homeFragment, HOME_TAG);
                        break;
                    }
                    case R.id.nav_search: {
                        ft.replace(R.id.content, articleResultFragment, ARTICLES_TAG);
                        break;
                    }
                    case R.id.nav_books: {
                        ft.replace(R.id.content, bestSellerBooksFragment, BOOKS_TAG);
                        break;
                    }
                    case R.id.nav_settings: {
                        ft.replace(R.id.content, settingsFragment, SETTINGS_TAG);
                        break;
                    }

                }
                ft.commit();
                return true;
            }
        });
        navView.setSelectedItemId(R.id.home);
    }
}
