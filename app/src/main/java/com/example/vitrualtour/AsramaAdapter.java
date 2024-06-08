package com.example.vitrualtour;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    }

    @Override
    public int getItemCount() {
        return asramaList.size();
    }

    public static class AsramaViewHolder extends RecyclerView.ViewHolder {
        public TextView asramaName;

        public AsramaViewHolder(View view, final OnItemClickListener listener) {
            super(view);
            asramaName = view.findViewById(R.id.text_asrama);
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
