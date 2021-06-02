package com.example.imageapptest.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imageapptest.R;
import com.example.imageapptest.model.Word;

import java.util.LinkedList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder>{

    private List<Word> words = new LinkedList<>();
    public WordAdapter() {

    }

    public void setWords(List<Word> words) {
        this.words = words;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordAdapter.ViewHolder holder, int position) {
        holder.word.setText(words.get(position).getWord());
    }

    @Override
    public int getItemCount() {
        if (words.isEmpty()){
            return 0;
        }
        return words.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView word;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            word = itemView.findViewById(R.id.word);
        }
    }

}