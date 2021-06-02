package com.example.imageapptest.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {
    private static String baseUrl = "https://wordsapiv1.p.rapidapi.com";


    private static Retrofit getInstance(){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static WordApi getNasaApi(){
        return getInstance().create(WordApi.class);
    }
}
