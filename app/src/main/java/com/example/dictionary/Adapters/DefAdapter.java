package com.example.dictionary.Adapters;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.R;
import com.example.dictionary.models.definitions;
import com.example.dictionary.viewHolders.DefViewHolder;
import com.example.dictionary.viewHolders.PhoneticViewHolder;

public class DefAdapter extends RecyclerView.Adapter<DefViewHolder> {
    private Context context;
    private List<definitions> definitionsList;

    public DefAdapter(Context context, List<definitions> definitionsList) {
        this.context = context;
        this.definitionsList = definitionsList;
    }

    @NonNull
    @Override
    public DefViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefViewHolder(LayoutInflater.from(context).inflate(R.layout.def_litems,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DefViewHolder holder, int position) {

        holder.tvDef.setText("Definition: "+ definitionsList.get(position).getDefinition());
        holder.tvExample.setText("Example: "+definitionsList.get(position).getExample());

        StringBuilder synonyms = new StringBuilder();
        StringBuilder antonyms = new StringBuilder();

        synonyms.append(definitionsList.get(position).getSynonyms());
        antonyms.append(definitionsList.get(position).getAntonyms());

        holder.tvSynonyms.setText(synonyms);
        holder.tvAntonyms.setText(antonyms);

        holder.tvSynonyms.setSelected(true);
        holder.tvAntonyms.setSelected(true);

    }

    @Override
    public int getItemCount() {
        return definitionsList.size();
    }
}
