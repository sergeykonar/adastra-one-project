package com.example.imageapptest.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.imageapptest.R;
import com.example.imageapptest.adapters.DefinitionAdapter;
import com.example.imageapptest.model.Definition;
import com.example.imageapptest.model.Word;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BottomInfoFragment extends BottomSheetDialogFragment {


    private ListView definitionListView;

    private Word word;
    private List<Definition> definitionList;
    private DefinitionAdapter adapter;

    public BottomInfoFragment(Word word) {
        this.definitionList = word.getDefinitions();
        this.word = word;
    }

    public static BottomInfoFragment newInstance(Word word) {
        return new BottomInfoFragment(word);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new DefinitionAdapter(definitionList, getContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.word_info, container, false);
        definitionListView = view.findViewById(R.id.defInfo);
        definitionListView.setAdapter(adapter);


        Toast.makeText(getContext(), word.getWord(), Toast.LENGTH_LONG).show();

        return view;
    }
}
