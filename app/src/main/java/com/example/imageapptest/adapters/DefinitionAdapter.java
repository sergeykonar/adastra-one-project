package com.example.imageapptest.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.imageapptest.R;
import com.example.imageapptest.model.Definition;

import java.util.List;

public class DefinitionAdapter extends BaseAdapter {

    private List<Definition> list;
    private Context context;

    public DefinitionAdapter(List<Definition> definitions, Context context) {
        this.list = definitions;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(context).inflate(R.layout.word_info_item, parent, false);
        TextView partOfSpeech = view.findViewById(R.id.partOfSpeech);
        TextView definition = view.findViewById(R.id.definition);
        partOfSpeech.setText(list.get(position).getPartOfSpeech());
        definition.setText(list.get(position).getDefinition());
        return view;
    }
}
