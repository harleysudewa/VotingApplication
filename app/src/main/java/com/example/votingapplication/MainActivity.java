package com.example.votingapplication;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataHelper dbHandler = new DataHelper(this, DataHelper.DATABASE_NAME, null, DataHelper.DATABASE_VERSION);

        ArrayList<Vote> votes = new ArrayList<Vote>();
        votes.add(new Vote("Orang Utan", dbHandler.getVoteAmount(1)));
        votes.add(new Vote("Hillary", dbHandler.getVoteAmount(2)));
        votes.add(new Vote("Peter", dbHandler.getVoteAmount(3)));
        votes.add(new Vote("Alex", dbHandler.getVoteAmount(4)));

        RecyclerView recyclerView = findViewById(R.id.rv_vote_list);
        CustomRecyclerAdapter recyclerViewAdapter = new CustomRecyclerAdapter(votes);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(view -> {
            finish();
        });
    }
}

