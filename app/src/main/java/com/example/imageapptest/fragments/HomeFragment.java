package com.example.imageapptest.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.imageapptest.R;
import com.example.imageapptest.api.NasaApi;
import com.example.imageapptest.api.RetroClient;
import com.example.imageapptest.model.Word;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;


public class HomeFragment extends Fragment {

    private RecyclerView wordsView;
    private FloatingActionButton addWord;

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        getApi();


    }

    private void getApi(){
        NasaApi nasaApi = RetroClient.getNasaApi();
        Call<Word> call = nasaApi.getMyJson("car");

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        wordsView = view.findViewById(R.id.wordList);
        addWord = view.findViewById(R.id.addWord);
        addWord.setOnClickListener(addWordlistener);

        return view;
    }

    private View.OnClickListener addWordlistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getContext(), "FAB", Toast.LENGTH_LONG).show();
            BottomAddFragment bottomAddFragment = new BottomAddFragment(getContext());
            bottomAddFragment.setContentView(R.layout.add_word);
            bottomAddFragment.show();

        }
    };
}