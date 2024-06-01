package com.example.vitrualtour;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class PutraFragment extends Fragment {

    private RecyclerView recyclerView;
    private AsramaAdapter adapter;
    private List<Asrama> asramaList;

    public PutraFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_putra, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_putra);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        asramaList = new ArrayList<>();
        asramaList.add(new Asrama("Asrama A", R.drawable.a));
        asramaList.add(new Asrama("Asrama E/F", R.drawable.f));
        asramaList.add(new Asrama("Asrama G", R.drawable.g));
        asramaList.add(new Asrama("Asrama K", R.drawable.k));
        asramaList.add(new Asrama("Asrama M", R.drawable.m));
        asramaList.add(new Asrama("Asrama N", R.drawable.n));
        asramaList.add(new Asrama("Asrama Q", R.drawable.q));

        adapter = new AsramaAdapter(asramaList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
