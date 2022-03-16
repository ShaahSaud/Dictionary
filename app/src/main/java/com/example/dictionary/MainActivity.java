package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dictionary.Adapters.MeaningAdapter;
import com.example.dictionary.Adapters.PhoneticAdapter;
import com.example.dictionary.models.ApiResponse;

public class MainActivity extends AppCompatActivity {
    SearchView searchView;
    TextView tvWord;
    RecyclerView rec_phonetics,rec_meanings;
    ProgressDialog progressDialog;
    PhoneticAdapter phoneticAdapter;
    MeaningAdapter meaningAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search_view);
        tvWord = findViewById(R.id.tvWord);
        rec_phonetics = findViewById(R.id.rec_phonetics);
        rec_meanings = findViewById(R.id.rec_meanings);
        progressDialog = new ProgressDialog(this);

        progressDialog.setTitle("Loading...");
        progressDialog.show();

        RequestManger manger = new RequestManger(MainActivity.this);
        manger.getWordMeaning(listner,"hello");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Fetching Response for"+ query);
                progressDialog.show();

                RequestManger manger = new RequestManger(MainActivity.this);
                manger.getWordMeaning(listner,query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


    }
    private final onFetchDataListner listner = new onFetchDataListner() {
        @Override
        public void onFetchData(ApiResponse apiResponse, String message) {
            progressDialog.dismiss();

            if(apiResponse==null){
                Toast.makeText(MainActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();

                return;
            }
            showData(apiResponse);
        }

        @Override
        public void onError(String message) {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showData(ApiResponse apiResponse) {
        tvWord.setText("Word: "+ apiResponse.getWord());
        rec_phonetics.setHasFixedSize(true);
        rec_phonetics.setLayoutManager(new GridLayoutManager(this,1));
        phoneticAdapter = new PhoneticAdapter(this,apiResponse.getPhonetics());
        rec_phonetics.setAdapter(phoneticAdapter);

        rec_meanings.setHasFixedSize(true);
        rec_meanings.setLayoutManager(new GridLayoutManager(this,1));
        meaningAdapter = new MeaningAdapter(this,apiResponse.getMeanings());
        rec_meanings.setAdapter(meaningAdapter);
    }
}