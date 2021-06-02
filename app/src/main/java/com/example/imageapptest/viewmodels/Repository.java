package com.example.imageapptest.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.imageapptest.db.WordDatabase;
import com.example.imageapptest.model.Word;

import java.util.List;

public class Repository {
    private MutableLiveData<List<Word>> wordsData;
    private WordDatabase wordDatabase;
    public Repository(Application application) {
        wordsData = new MutableLiveData<>();
        this.wordDatabase = WordDatabase.getDatabase(application);
        Log.e(getClass().getName(), "Created");
        /**
         * TODO: Initialize Room database
         * TODO: implement methods to clear/insert data in the table
         */

    }


    public MutableLiveData<List<Word>> getData() {
        return wordsData;
    }
}
