package com.example.imageapptest.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.imageapptest.R;
import com.example.imageapptest.model.Word;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomInfoFragment extends BottomSheetDialogFragment {

    private Word word;

    public BottomInfoFragment(Word word) {
        this.word = word;
    }

    public static BottomInfoFragment newInstance(Word word) {
        return new BottomInfoFragment(word);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.word_info_item, container, false);

        Toast.makeText(getContext(), word.getWord(), Toast.LENGTH_LONG).show();
        return view;
    }
}
