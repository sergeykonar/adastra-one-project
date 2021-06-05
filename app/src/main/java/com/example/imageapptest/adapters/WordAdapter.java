package com.example.imageapptest.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imageapptest.R;
import com.example.imageapptest.fragments.BottomInfoFragment;
import com.example.imageapptest.model.Word;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder>{

    private List<Word> words = new LinkedList<>();
    private Context context ;
    public WordAdapter(Context context) {
        this.context = context;
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
        holder.cardView.setTag(position);
        holder.cardView.setOnClickListener(l);
    }

    private View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position = (int) v.getTag();
            show(words.get(position));
        }
    };

    void show(Word word){

        FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
        BottomInfoFragment bottomSheetDialog = BottomInfoFragment.newInstance(word);
        bottomSheetDialog.show(manager, "INFO");

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
        private CardView cardView;
        private ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            word = itemView.findViewById(R.id.word);
            cardView =  itemView.findViewById(R.id.wordItem);
            constraintLayout = itemView.findViewById(R.id.itemLayout);
        }
    }

}