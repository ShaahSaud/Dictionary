package com.example.dictionary.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.R;

public class DefViewHolder extends RecyclerView.ViewHolder {
    public TextView tvDef,tvExample,tvSynonyms,tvAntonyms;
    public DefViewHolder(@NonNull View itemView) {
        super(itemView);
        tvDef = itemView.findViewById(R.id.tvDef);
        tvExample = itemView.findViewById(R.id.tvExample);
        tvSynonyms = itemView.findViewById(R.id.tvSynonyms);
        tvAntonyms = itemView.findViewById(R.id.tvAntonyms);
    }
}
