package com.example.imageapptest.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.example.imageapptest.R;
import com.example.imageapptest.api.RetroClient;
import com.example.imageapptest.api.WordApi;
import com.example.imageapptest.model.Word;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;

public class BottomAddFragment extends BottomSheetDialog {


    public BottomAddFragment(@NonNull Context context) {
        super(context);

    }

    private void getApi(){
        WordApi wordApi = RetroClient.getNasaApi();
        Call<Word> call = wordApi.getMyJson("car");

        call.enqueue(new Callback<Word>() {
            @Override
            public void onResponse(Call<Word> call, retrofit2.Response<Word> response) {
                if(response.isSuccessful()){
                    Log.e("SUCCESSFUL API", response.message());
                    Word word = response.body();
                    Log.e("RESPONSE", word.getWord());


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);


    }
    @OnClick(R.id.findBtn)
    void findWordDefinition(){
        dismiss();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }


}
