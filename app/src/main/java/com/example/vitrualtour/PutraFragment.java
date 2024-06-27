package com.example.vitrualtour;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import java.util.Arrays;
import java.util.List;

public class PutraFragment extends Fragment {

    // Deklarasikan tombol-tombol di sini
    private LinearLayout btnAsramaA, btnAsramaF, btnAsramaG, btnAsramaK, btnAsramaM, btnAsramaN, btnAsramaQ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_putra, container, false);

        // Inisialisasi tombol-tombol
        btnAsramaA = view.findViewById(R.id.btn_asrama_a);
        btnAsramaF = view.findViewById(R.id.btn_asrama_f);
        btnAsramaG = view.findViewById(R.id.btn_asrama_g);
        btnAsramaK = view.findViewById(R.id.btn_asrama_k);
        btnAsramaM = view.findViewById(R.id.btn_asrama_m);
        btnAsramaN = view.findViewById(R.id.btn_asrama_n);
        btnAsramaQ = view.findViewById(R.id.btn_asrama_q);

        // Tambahkan OnClickListener untuk setiap tombol
        btnAsramaA.setOnClickListener(v -> navigateToAsramaFragment(new Asrama_A_Fragment()));
        btnAsramaF.setOnClickListener(v -> navigateToAsramaFragment(new Asrama_F_Fragment()));
        btnAsramaG.setOnClickListener(v -> navigateToAsramaFragment(new Asrama_G_Fragment()));
        btnAsramaK.setOnClickListener(v -> navigateToAsramaFragment(new Asrama_K_Fragment()));
        btnAsramaM.setOnClickListener(v -> navigateToAsramaFragment(new Asrama_M_Fragment()));
        btnAsramaN.setOnClickListener(v -> navigateToAsramaFragment(new Asrama_N_Fragment()));
        btnAsramaQ.setOnClickListener(v -> navigateToAsramaFragment(new Asrama_Q_Fragment()));

        return view;
    }

    private void navigateToAsramaFragment(Fragment fragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
