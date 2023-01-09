package com.example.ensa_transfert.Retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// va nous permettre la communication avec le service
public class RetrofitService {

    private Retrofit retrofit;
    private String baseApiUrl = "http://192.168.1.127:4200";

    public RetrofitService(){
        initializeRetrofit();
    }

    private void initializeRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseApiUrl)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }
}
