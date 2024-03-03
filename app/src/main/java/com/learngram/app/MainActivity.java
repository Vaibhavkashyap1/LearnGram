package com.learngram.app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.learngram.app.adapters.PostAdapter;
import com.learngram.app.adapters.StoryAdapter;
import com.learngram.app.data.Post;
import com.learngram.app.data.Story;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView storyRecyclerView;
    private List<Story> storyList;

    private RecyclerView postRecyclerView;

    private List<Post> postList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        StoryAdapter storyAdapter = new StoryAdapter(storyList, this);
        storyRecyclerView.setAdapter(storyAdapter);
        storyRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        storyAdapter.setOnRemoveStoryListener((view, position) -> {
//            Toast.makeText(this, "Remove story " + position, Toast.LENGTH_SHORT).show();
            storyList.remove(position);
            storyAdapter.notifyDataSetChanged();
//            what to do when image of story clicked
        });


        PostAdapter postAdapter = new PostAdapter(postList, this);
        postRecyclerView.setAdapter(postAdapter);
        postRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initialize() {
        this.storyRecyclerView = findViewById(R.id.story_container);
        this.postRecyclerView = findViewById(R.id.single_post);
        this.storyList = new ArrayList<>();
        this.postList = new ArrayList<>();
//        creating few default stories
        this.storyList.add(new Story(12, "Vaibhav...", R.drawable.story1));
        this.storyList.add(new Story(13, "Yash...", R.drawable.story2));
        this.storyList.add(new Story(14, "Ravi Kumar...", R.drawable.story3));
        this.storyList.add(new Story(15, "Ankit K...", R.drawable.story4));
        this.storyList.add(new Story(16, "Amardeep...", R.drawable.story5));
        this.storyList.add(new Story(17, "Samardeep...", R.drawable.story6));
        this.storyList.add(new Story(18, "Yashu...", R.drawable.story1));
        this.storyList.add(new Story(19, "Priyanshu...", R.drawable.story2));
//        adding items to post list

        this.postList.add(new Post(1,
                R.drawable.profile,
                R.drawable.story1,
                "This is first post caption", "sponsored",
                "400 liked",
                "View all 50 comments", "v_kashyap__18"));
        this.postList.add(new Post(2,
                R.drawable.profile,
                R.drawable.story5,
                "This is  second post caption", "sponsored",
                "450 liked",
                "View all 100 comments", "v_kashyap__18"));

    }

}
