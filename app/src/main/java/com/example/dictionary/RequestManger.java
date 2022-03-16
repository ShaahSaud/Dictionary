package com.example.dictionary;

import android.content.Context;
import android.widget.Toast;

import com.example.dictionary.models.ApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import java.util.*;

public class RequestManger {

    final String url="https://api.dictionaryapi.dev/api/v2/";
    Context context;
    Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();


    public RequestManger(Context context) {
        this.context = context;
    }

    public void getWordMeaning(onFetchDataListner listner, String word){
        callDic callDic = retrofit.create(RequestManger.callDic.class);
        Call<List<ApiResponse>> call = callDic.callMeanings(word);

        try {
            call.enqueue(new Callback<List<ApiResponse>>() {
                @Override
                public void onResponse(Call<List<ApiResponse>> call, Response<List<ApiResponse>> response) {
                    if(!response.isSuccessful()){
                        Toast.makeText(context.getApplicationContext(), "Error Occurred", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    listner.onFetchData(response.body().get(0),response.message());
                }

                @Override
                public void onFailure(Call<List<ApiResponse>> call, Throwable t) {
                    listner.onError("Request Failed!!");
                }
            });
        }
        catch (Exception e){
            Toast.makeText(context.getApplicationContext(), "Error Occurred", Toast.LENGTH_SHORT).show();
        }
    }

    public interface callDic{
        @GET("entries/en/{word}")
        Call<List<ApiResponse>> callMeanings(
                @Path("word") String word
        );

    }

}
