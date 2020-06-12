package com.example.snakecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    Button b1, b2,b3,b4;
    public static String veremail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.mainregbut);
        b2 = (Button) findViewById(R.id.mainlogbut);
        b3 = (Button) findViewById(R.id.playbut);
        b4 = (Button) findViewById(R.id.leaderboard);



        Intent i = getIntent();
        String email = i.getStringExtra("email");
        if (email != null) {
            final TextView textViewToChange = (TextView) findViewById(R.id.getemail);
            textViewToChange.setText("Hello," + email);
            veremail = email;
        }
        if(email == null)
        {
            email = "guest";
            final TextView textViewToChange = (TextView) findViewById(R.id.getemail);
            textViewToChange.setText("Hello," + email);
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SnakeActivity.class);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LeaderBoardActivity.class);
                startActivity(i);
            }
        });
    }

}