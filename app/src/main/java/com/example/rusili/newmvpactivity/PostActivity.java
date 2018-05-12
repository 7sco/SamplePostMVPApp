package com.example.rusili.newmvpactivity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.rusili.newmvpactivity.model.Post;
import com.example.rusili.newmvpactivity.network.PostService;
import com.example.rusili.newmvpactivity.rv.PostAdapter;

import java.util.List;

public class PostActivity extends AppCompatActivity implements PostContract.View {
    private PostContract.Presenter presenter;

    private RecyclerView postRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_activity);

        setupRecyclerView();

        presenter = new PostPresenter(this,
                new PostService());
        presenter.start();
    }

    @Override
    public void showPosts(@Nullable List<Post> postList) {
        PostAdapter adapter = new PostAdapter(postList);
        postRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "Error getting posts.", Toast.LENGTH_SHORT).show();
    }

    private void setupRecyclerView() {
        postRecyclerView = findViewById(R.id.postRecyclerView);
        postRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
