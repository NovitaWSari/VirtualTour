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

public class PutriFragment extends Fragment {

    private RecyclerView recyclerView;
    private AsramaAdapter adapter;
    private List<Asrama> asramaList;

    public PutriFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_putri, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_putri);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        asramaList = new ArrayList<>();
        asramaList.add(new Asrama("Asrama B", R.drawable.b));
        asramaList.add(new Asrama("Asrama C", R.drawable.c));
        asramaList.add(new Asrama("Asrama D", R.drawable.d));
        asramaList.add(new Asrama("Asrama H", R.drawable.h));
        asramaList.add(new Asrama("Asrama I", R.drawable.i));
        asramaList.add(new Asrama("Asrama J", R.drawable.j));
        asramaList.add(new Asrama("Asrama L", R.drawable.l));
        asramaList.add(new Asrama("Asrama O", R.drawable.o));
        asramaList.add(new Asrama("Asrama P", R.drawable.p));

        adapter = new AsramaAdapter(asramaList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
