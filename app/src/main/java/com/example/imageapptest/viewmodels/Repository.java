package com.example.imageapptest.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.imageapptest.api.RetroClient;
import com.example.imageapptest.api.WordApi;
import com.example.imageapptest.db.WordDao;
import com.example.imageapptest.db.WordDatabase;
import com.example.imageapptest.model.Word;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class Repository {
    private MutableLiveData<List<Word>> wordsData;
    private WordDatabase wordDatabase;
    public Repository(Application application) {
        this.wordsData = new MutableLiveData<>();
        this.wordDatabase = WordDatabase.getDatabase(application);
        List<Word> list = wordDatabase.wordDao().getAll();
        wordsData.setValue(list);
        Log.e(getClass().getName(), "Created");
        /**
         * TODO: Initialize Room database
         * TODO: implement methods to clear/insert data in the table
         */

    }


    public MutableLiveData<List<Word>> getData() {

        return wordsData;
    }

    public void insertWord(Word word) {
        WordDao wordDao = wordDatabase.wordDao();
        wordDao.insert(word);

        wordsData.setValue(wordDao.getAll());
    }

    public void getWord(String word){
        WordApi wordApi = RetroClient.getWordApi();
        Call<Word> call = wordApi.getMyJson(word);
        call.enqueue(new Callback<Word>() {
            @Override
            public void onResponse(Call<Word> call, retrofit2.Response<Word> response) {
                if(response.isSuccessful()){
                    Log.e("SUCCESSFUL API", response.message());
                    Word word = response.body();
                    Log.e("RESPONSE", word.getWord());

                    insertWord(word);

                }else {
                    Log.e("ERROR OCCURRED", response.message());
                    try {
                        Log.e("MESSAGE",response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Word> call, Throwable t) {
                Log.e("API FAILURE", t.getMessage());
            }
        });
    }
}
