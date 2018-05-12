package com.example.rusili.newmvpactivity;

import com.example.rusili.newmvpactivity.model.Post;

import java.util.List;

public interface PostContract {

    interface View {
        void showPosts(List<Post> postList);
        void showErrorMessage();
    }

    interface Presenter {
        void start();
    }
}
