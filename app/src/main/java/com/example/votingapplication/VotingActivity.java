package com.example.votingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VotingActivity extends AppCompatActivity {

    private TextView txtFirst;
    private TextView txtSecond;

    private Button btnFirst;
    private Button btnSecond;

    private int scoreFirst = 0;
    private int scoreSecond = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);

        // initializing textview
        txtFirst = (TextView) findViewById(R.id.txtFirst);
        txtSecond = (TextView) findViewById(R.id.txtSecond);

        // initializing button view
        btnFirst = (Button) findViewById(R.id.btnFirst);
        btnSecond = (Button) findViewById(R.id.btnSecond);

        // setting initial value to text view
        txtFirst.setText(String.valueOf(0));
        txtSecond.setText(String.valueOf(0));

        // updating textview on button click
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreFirst++;
                txtFirst.setText(String.valueOf(scoreFirst));
            }
        });

        // updating textview on button click
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreSecond++;
                txtSecond.setText(String.valueOf(scoreSecond));
            }
        });
    }
}
