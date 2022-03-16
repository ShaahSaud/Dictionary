package com.example.dictionary;

import com.example.dictionary.models.ApiResponse;

public interface onFetchDataListner {

    void onFetchData(ApiResponse apiResponse,String message);
    void onError(String message);
}
