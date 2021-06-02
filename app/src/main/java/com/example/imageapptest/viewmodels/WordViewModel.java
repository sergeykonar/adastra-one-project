package com.example.imageapptest.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.imageapptest.model.Word;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private Repository repository;
    private MutableLiveData<List<Word>> data;
    public WordViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
        this.data = repository.getData();
    }

    public MutableLiveData<List<Word>> getWordsData(){
        return repository.getData();
    }

    public void insertWord(Word word){
        repository.insertWord(word);
    }

    public void getWord(String mWord) {
        repository.getWord(mWord);

    }
}
