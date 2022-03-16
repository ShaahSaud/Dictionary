package com.example.dictionary.viewHolders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.R;

public class PhoneticViewHolder extends RecyclerView.ViewHolder {

    public TextView tvPhonetic;
    public ImageButton btn_audio;
    public PhoneticViewHolder(@NonNull View itemView) {
        super(itemView);

        tvPhonetic = itemView.findViewById(R.id.tvPhonetic);
        btn_audio = itemView.findViewById(R.id.btn_audio);
    }
}
