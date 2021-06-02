package com.example.imageapptest.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.imageapptest.MainActivity;
import com.example.imageapptest.R;
import com.example.imageapptest.adapters.WordAdapter;
import com.example.imageapptest.api.RetroClient;
import com.example.imageapptest.api.WordApi;
import com.example.imageapptest.model.Word;
import com.example.imageapptest.viewmodels.WordViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;

public class BottomAddFragment extends BottomSheetDialogFragment {

    @BindView(R.id.wordText) TextInputEditText wordText;

    public static BottomAddFragment newInstance() {
        return new BottomAddFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_word, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.findBtn)
    void findWordDefinition(){
        String mWord = wordText.getText().toString();

        WordViewModel wordViewModel = new ViewModelProvider(requireActivity()).get(WordViewModel.class);
        wordViewModel.getWord(mWord);
        dismiss();
    }

}
