package com.example.vitrualtour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class PutriFragment extends Fragment {

    private LinearLayout btnAsramaB, btnAsramaC, btnAsramaD, btnAsramaH, btnAsramaI, btnAsramaJ, btnAsramaL, btnAsramaO, btnAsramaP;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_putri, container, false);

        btnAsramaB = view.findViewById(R.id.btn_asrama_b);
        btnAsramaC = view.findViewById(R.id.btn_asrama_c);
        btnAsramaD = view.findViewById(R.id.btn_asrama_d);
        btnAsramaH = view.findViewById(R.id.btn_asrama_h);
        btnAsramaI = view.findViewById(R.id.btn_asrama_i);
        btnAsramaJ = view.findViewById(R.id.btn_asrama_j);
        btnAsramaL = view.findViewById(R.id.btn_asrama_l);
        btnAsramaO = view.findViewById(R.id.btn_asrama_o);
        btnAsramaP = view.findViewById(R.id.btn_asrama_p);

        btnAsramaB.setOnClickListener(v -> navigateToAsramaFragment(new Asrama_B_Fragment()));
        btnAsramaC.setOnClickListener(v -> navigateToAsramaFragment(new Asrama_C_Fragment()));
        btnAsramaD.setOnClickListener(v -> navigateToAsramaFragment(new Asrama_D_Fragment()));
        btnAsramaH.setOnClickListener(v -> navigateToAsramaFragment(new Asrama_H_Fragment()));
        btnAsramaI.setOnClickListener(v -> navigateToAsramaFragment(new Asrama_I_Fragment()));
        btnAsramaJ.setOnClickListener(v -> navigateToAsramaFragment(new Asrama_J_Fragment()));
        btnAsramaL.setOnClickListener(v -> navigateToAsramaFragment(new Asrama_L_Fragment()));
        btnAsramaO.setOnClickListener(v -> navigateToAsramaFragment(new Asrama_O_Fragment()));
        btnAsramaP.setOnClickListener(v -> navigateToAsramaFragment(new Asrama_P_Fragment()));

        return view;
    }

    private void navigateToAsramaFragment(Fragment fragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
