package com.example.ensa_transfert.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// va nous permettre la communication avec le service
public class RetrofitService {

    private Retrofit retrofit;
    private String baseApiUrl = "https://client-service-01.herokuapp.com";
    public Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    OkHttpClient client = new OkHttpClient();

    public RetrofitService(){
        initializeRetrofit();
    }

    private void initializeRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseApiUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }
}
