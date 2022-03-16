package com.example.dictionary.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.R;

public class MeaningViewHolder extends RecyclerView.ViewHolder {
    public TextView tvPartsOfSpeech;
    public RecyclerView rec_def;
    public MeaningViewHolder(@NonNull View itemView) {
        super(itemView);
        tvPartsOfSpeech = itemView.findViewById(R.id.tvPartsOfSpeech);
        rec_def = itemView.findViewById(R.id.rec_def);

    }
}
