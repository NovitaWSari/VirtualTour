package com.example.vitrualtour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Get the LinearLayouts for Shape 1 and Shape 2
        View shape1 = view.findViewById(R.id.shape1);
        View shape2 = view.findViewById(R.id.shape2);

        // Set onClickListener for Shape 1
        shape1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to PutraFragment and update BottomNavigationView
                ((MainActivity) getActivity()).navigateToFragment(R.id.putra);
            }
        });

        // Set onClickListener for Shape 2
        shape2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to PutriFragment and update BottomNavigationView
                ((MainActivity) getActivity()).navigateToFragment(R.id.putri);
            }
        });

        return view;
    }
}
