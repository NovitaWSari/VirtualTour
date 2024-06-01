package com.example.vitrualtour;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AsramaAdapter extends RecyclerView.Adapter<AsramaAdapter.AsramaViewHolder> {
    private List<Asrama> asramaList;

    public AsramaAdapter(List<Asrama> asramaList) {
        this.asramaList = asramaList;
    }

    @NonNull
    @Override
    public AsramaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_asrama, parent, false);
        return new AsramaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AsramaViewHolder holder, int position) {
        Asrama asrama = asramaList.get(position);
        holder.nameTextView.setText(asrama.getName());
        holder.imageView.setImageResource(asrama.getImageResource());
    }

    @Override
    public int getItemCount() {
        return asramaList.size();
    }

    public static class AsramaViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        ImageView imageView;

        public AsramaViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.text_asrama);
            imageView = itemView.findViewById(R.id.image_asrama);
        }
    }
}
