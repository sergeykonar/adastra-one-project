package com.example.imageapptest.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.imageapptest.R;
import com.example.imageapptest.adapters.WordAdapter;
import com.example.imageapptest.api.WordApi;
import com.example.imageapptest.api.RetroClient;
import com.example.imageapptest.model.Word;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;


public class HomeFragment extends Fragment {

    @BindView(R.id.wordList) RecyclerView wordsView;
    public Unbinder unbinder;

    private List<Word> words;

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Word word = new Word();
        Word word2 = new Word();
        word.setWord("Test");
        word2.setWord("Test2");
        words = Arrays.asList(word, word2);

        WordAdapter wordAdapter = new WordAdapter(words);



        unbinder = ButterKnife.bind(this, view);
        wordsView.setAdapter(wordAdapter);
        wordsView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }


    @SuppressLint("NonConstantResourceId")
    @OnClick(R.id.addWord)
    void addWord(){
        Toast.makeText(getContext(), "FAB", Toast.LENGTH_LONG).show();
        BottomAddFragment bottomAddFragment = new BottomAddFragment(getContext());
        bottomAddFragment.setContentView(R.layout.add_word);
        bottomAddFragment.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}