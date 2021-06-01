package com.example.imageapptest.api;

import com.example.imageapptest.model.Word;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NasaApi {

    String API_KEY = "a78f19fdbamshcf02621665fbdccp109ae7jsnb03720b7dcc8";

    @GET("/words/{word}/definitions?rapidapi-key=" + API_KEY)
    Call<Word> getMyJson(@Path("word") String word);
}
