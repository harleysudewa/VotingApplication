package com.example.votingapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button buttonVote;
    private ListView listViewResults;
    private ArrayList<String> resultList;
    private ArrayAdapter<String> resultAdapter;
    private DataHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonVote = findViewById(R.id.buttonVote);
        listViewResults = findViewById(R.id.listViewResults);
        resultList = new ArrayList<>();
        resultAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, resultList);
        dbHelper = new DataHelper(this);

        listViewResults.setAdapter(resultAdapter);

        buttonVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(MainActivity.this, VotingActivity.class);
                startActivity(inte);
            }
        });
    }
}

