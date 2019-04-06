package com.example.hijiriakalender.remote;

import com.example.hijiriakalender.model.APIEndpoint;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HijriService {

    public static final String BASE_URL = "http://api.aladhan.com/v1/";

    private Retrofit retrofit;

    public static APIEndpoint getAPI(){
        final Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        return retrofit.create(APIEndpoint.class);
    }
}
