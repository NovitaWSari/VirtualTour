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

public class PutriFragment extends Fragment {

    private RecyclerView recyclerView;
    private AsramaAdapter adapter;
    private List<String> asramaList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_putri, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_putri);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        asramaList = Arrays.asList("Asrama B", "Asrama C", "Asrama D", "Asrama H", "Asrama I", "Asrama J", "Asrama L", "Asrama O", "Asrama P");
        adapter = new AsramaAdapter(asramaList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(position -> {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new Asrama_B_Fragment();
                    break;
                case 1:
                    fragment = new Asrama_C_Fragment();
                    break;
                case 2:
                    fragment = new Asrama_D_Fragment();
                    break;
                case 3:
                    fragment = new Asrama_H_Fragment();
                    break;
                case 4:
                    fragment = new Asrama_I_Fragment();
                    break;
                case 5:
                    fragment = new Asrama_J_Fragment();
                    break;
                case 6:
                    fragment = new Asrama_L_Fragment();
                    break;
                case 7:
                    fragment = new Asrama_O_Fragment();
                    break;
                case 8:
                    fragment = new Asrama_P_Fragment();
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
