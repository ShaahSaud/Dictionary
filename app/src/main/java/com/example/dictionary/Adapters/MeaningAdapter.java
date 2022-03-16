package com.example.dictionary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.*;

import com.example.dictionary.R;
import com.example.dictionary.models.meanings;
import com.example.dictionary.viewHolders.MeaningViewHolder;
import com.example.dictionary.viewHolders.PhoneticViewHolder;

public class MeaningAdapter extends RecyclerView.Adapter<MeaningViewHolder> {

    private Context context;
    protected  List<meanings> meaningsList;

    public MeaningAdapter(Context context, List<meanings> meaningsList) {
        this.context = context;
        this.meaningsList = meaningsList;
    }

    @NonNull
    @Override
    public MeaningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningViewHolder(LayoutInflater.from(context).inflate(R.layout.meaning_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningViewHolder holder, int position) {
        holder.tvPartsOfSpeech.setText("Parts of Speech: "+meaningsList.get(position).getPartOfSpeech());
        holder.rec_def.setHasFixedSize(true);
        holder.rec_def.setLayoutManager(new GridLayoutManager(context,1));

        DefAdapter defAdapter = new DefAdapter(context,meaningsList.get(position).getDefinitions());
        holder.rec_def.setAdapter(defAdapter);
    }

    @Override
    public int getItemCount() {
        return meaningsList.size();
    }
}
