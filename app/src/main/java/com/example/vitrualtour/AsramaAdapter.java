package com.example.vitrualtour;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AsramaAdapter extends RecyclerView.Adapter<AsramaAdapter.AsramaViewHolder> {

    private List<String> asramaList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public AsramaAdapter(List<String> asramaList) {
        this.asramaList = asramaList;
    }

    @Override
    public AsramaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_asrama, parent, false);
        return new AsramaViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(AsramaViewHolder holder, int position) {
        String asrama = asramaList.get(position);
        holder.asramaName.setText(asrama);

        // Set gambar berdasarkan nama asrama
        int imageResId = getImageResourceId(asrama);
        holder.asramaImage.setImageResource(imageResId);
    }

    @Override
    public int getItemCount() {
        return asramaList.size();
    }

    private int getImageResourceId(String asramaName) {
        switch (asramaName) {
            case "Asrama A":
                return R.drawable.a;
            case "Asrama B":
                return R.drawable.b;
            case "Asrama C":
                return R.drawable.c;
            case "Asrama D":
                return R.drawable.d;
            case "Asrama F":
                return R.drawable.f;
            case "Asrama G":
                return R.drawable.g;
            case "Asrama H":
                return R.drawable.h;
            case "Asrama I":
                return R.drawable.i;
            case "Asrama J":
                return R.drawable.j;
            case "Asrama K":
                return R.drawable.k;
            case "Asrama L":
                return R.drawable.l;
            case "Asrama M":
                return R.drawable.m;
            case "Asrama N":
                return R.drawable.n;
            case "Asrama O":
                return R.drawable.o;
            case "Asrama P":
                return R.drawable.p;
            case "Asrama Q":
                return R.drawable.q;
            default:
                return R.drawable.placeholder_shape; // Gambar placeholder jika tidak ditemukan
        }
    }

    public static class AsramaViewHolder extends RecyclerView.ViewHolder {
        public TextView asramaName;
        public ImageView asramaImage;

        public AsramaViewHolder(View view, final OnItemClickListener listener) {
            super(view);
            asramaName = view.findViewById(R.id.text_asrama);
            asramaImage = view.findViewById(R.id.image_asrama);
            view.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }
}
