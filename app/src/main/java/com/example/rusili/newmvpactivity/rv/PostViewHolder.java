package com.example.rusili.newmvpactivity.rv;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.rusili.newmvpactivity.R;
import com.example.rusili.newmvpactivity.model.Post;

public class PostViewHolder extends RecyclerView.ViewHolder {
    private TextView titleView;
    private TextView bodyView;

    public PostViewHolder(View itemView) {
        super(itemView);
        titleView = itemView.findViewById(R.id.title);
        bodyView = itemView.findViewById(R.id.body);
    }

    public void bind(@Nullable Post post){
        titleView.setText(post.getTitle());
        bodyView.setText(post.getBody());
    }
}
