package com.example.vitrualtour;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;
import java.util.List;

public class PutraFragment extends Fragment {

    private RecyclerView recyclerView;
    private AsramaAdapter adapter;
    private List<String> asramaList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_putra, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_putra);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        asramaList = Arrays.asList("Asrama A", "Asrama F", "Asrama G", "Asrama K", "Asrama M", "Asrama N", "Asrama Q");
        adapter = new AsramaAdapter(asramaList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(position -> {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new Asrama_A_Fragment();
                    break;
                case 1:
                    fragment = new Asrama_F_Fragment();
                    break;
                case 2:
                    fragment = new Asrama_G_Fragment();
                    break;
                case 3:
                    fragment = new Asrama_K_Fragment();
                    break;
                case 4:
                    fragment = new Asrama_M_Fragment();
                    break;
                case 5:
                    fragment = new Asrama_N_Fragment();
                    break;
                case 6:
                    fragment = new Asrama_Q_Fragment();
                    break;
            }
            if (fragment != null) {
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
}
