package com.example.imageapptest.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.imageapptest.MainActivity;
import com.example.imageapptest.R;
import com.example.imageapptest.adapters.WordAdapter;
import com.example.imageapptest.api.WordApi;
import com.example.imageapptest.api.RetroClient;
import com.example.imageapptest.model.Word;
import com.example.imageapptest.viewmodels.WordViewModel;

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

    private WordViewModel wordViewModel;
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
        unbinder = ButterKnife.bind(this, view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        WordAdapter wordAdapter = new WordAdapter(getContext());
        wordsView.setAdapter(wordAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(wordsView.getContext(),DividerItemDecoration.VERTICAL);
        wordsView.addItemDecoration(dividerItemDecoration);
        wordViewModel = new ViewModelProvider(requireActivity()).get(WordViewModel.class);
        wordViewModel.getWordsData().observe(requireActivity(), new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                wordAdapter.setWords(words);
                Log.e(getTag(), "list updated");
            }
        });
        wordsView.setLayoutManager(layoutManager);
        return view;
    }


    @SuppressLint("NonConstantResourceId")
    @OnClick(R.id.addWord)
    void addWord(){
        BottomAddFragment bottomAddFragment = BottomAddFragment.newInstance();
        bottomAddFragment.show(getParentFragmentManager(), "ADD");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }






}