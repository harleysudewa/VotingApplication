package com.example.votingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicReference;

public class VotingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        Button btnVote = findViewById(R.id.btn_confirm);

        Button btn_candidate1 = findViewById(R.id.btn_candidate1);
        Button btn_candidate2 = findViewById(R.id.btn_candidate2);
        Button btn_candidate3 = findViewById(R.id.btn_candidate3);
        Button btn_candidate4 = findViewById(R.id.btn_candidate4);

        AtomicReference<Integer> selectedCandidate = new AtomicReference<>(0);

        btn_candidate1.setOnClickListener(view -> {
            selectedCandidate.set(1);
            btn_candidate1.setText("Terpilih");
            btn_candidate2.setText("Vote Kandidat 2");
            btn_candidate3.setText("Vote Kandidat 3");
            btn_candidate4.setText("Vote Kandidat 4");
        });

        btn_candidate2.setOnClickListener(view -> {
            selectedCandidate.set(2);
            btn_candidate1.setText("Vote Kandidat 1");
            btn_candidate2.setText("Terpilih");
            btn_candidate3.setText("Vote Kandidat 3");
            btn_candidate4.setText("Vote Kandidat 4");
        });

        btn_candidate3.setOnClickListener(view -> {
            selectedCandidate.set(3);
            btn_candidate1.setText("Vote Kandidat 1");
            btn_candidate2.setText("Vote Kandidat 2");
            btn_candidate3.setText("Terpilih");
            btn_candidate4.setText("Vote Kandidat 4");
        });

        btn_candidate4.setOnClickListener(view -> {
            selectedCandidate.set(4);
            btn_candidate1.setText("Vote Kandidat 1");
            btn_candidate2.setText("Vote Kandidat 2");
            btn_candidate3.setText("Vote Kandidat 3");
            btn_candidate4.setText("Terpilih");
        });

        btnVote.setOnClickListener(view -> {
            if (selectedCandidate.get() == 0) {
                CharSequence text = "Pilih kandidat untuk divoting terlebih dahulu!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(this /* MyActivity */, text, duration);
                toast.show();
            } else {
                DataHelper dbHandler = new DataHelper(this, DataHelper.DATABASE_NAME, null, DataHelper.DATABASE_VERSION);
                Vote vote = new Vote(name, selectedCandidate.get());
                dbHandler.addVote(vote);
                Toast.makeText(this, "Vote telah disubmit!", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });


    }
}
