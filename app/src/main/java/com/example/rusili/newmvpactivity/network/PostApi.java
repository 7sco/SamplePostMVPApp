package com.example.rusili.newmvpactivity.network;

import com.example.rusili.newmvpactivity.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApi {

    @GET("posts")
    Call<List<Post>> getPostsList();
}
