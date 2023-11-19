package com.example.votingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        DataHelper dbHandler = new DataHelper(this, DataHelper.DATABASE_NAME, null, DataHelper.DATABASE_VERSION);

        buttonLogin.setOnClickListener(view -> {
            if(editTextPassword.getText().toString().equals("admin")){
                if (dbHandler.getVote(editTextUsername.getText().toString()) == null){

                    Toast.makeText(this,
                            "Login Berhasil!",
                            Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(this, VotingActivity.class);
                    myIntent.putExtra("name", editTextUsername.getText().toString());
                    editTextUsername.setText("");
                    editTextPassword.setText("");
                    startActivity(myIntent);
                } else {
                    editTextUsername.setText("");
                    editTextPassword.setText("");
                    Toast.makeText(this,
                            "Anda telah memilih kandidat, mengarahkan ke layar daftar voting.",
                            Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(this, MainActivity.class);
                    myIntent.putExtra("name", editTextUsername.getText().toString());
                    startActivity(myIntent);
                }

            } else {
                editTextUsername.setText("");
                editTextPassword.setText("");
                Toast.makeText(this, "Login Gagal, Username atau password salah!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
