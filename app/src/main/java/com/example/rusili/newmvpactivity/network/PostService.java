package com.example.rusili.newmvpactivity.network;

import android.support.annotation.NonNull;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostService {
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com";

    private final Retrofit retrofit;

    public PostService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @NonNull
    public PostApi getPostApi() {
        return retrofit.create(PostApi.class);
    }
}
