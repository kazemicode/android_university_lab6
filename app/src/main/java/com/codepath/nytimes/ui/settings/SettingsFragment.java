package com.codepath.nytimes.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.codepath.nytimes.R;

public class SettingsFragment extends Fragment {


    public SettingsFragment() {
    }

    public static SettingsFragment newInstance() {

        return new SettingsFragment();
    }

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_settings, parent, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
