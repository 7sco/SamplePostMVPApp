package com.example.rusili.newmvpactivity;

import android.support.annotation.NonNull;

import com.example.rusili.newmvpactivity.model.Post;
import com.example.rusili.newmvpactivity.network.PostApi;
import com.example.rusili.newmvpactivity.network.PostService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostPresenter implements PostContract.Presenter {
    private PostContract.View viewImpl;
    private PostService postService;

    public PostPresenter(@NonNull PostContract.View view,
                         @NonNull PostService postService) {
        this.viewImpl = view;
        this.postService = postService;
    }

    @Override
    public void start() {
        getPosts();
    }

    private void getPosts() {
        Call<List<Post>> postCall = postService.getPostApi().getPostsList();

        postCall.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> postList = response.body();

                if (!postList.isEmpty()) {
                    viewImpl.showPosts(postList);
                } else {
                    viewImpl.showErrorMessage();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                viewImpl.showErrorMessage();
            }
        });
    }
}
