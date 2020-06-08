package com.example.snakecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LeaderBoardActivity extends AppCompatActivity {
DatabaseHelper db;
ArrayList<String> listEmail;
ArrayList<String> listScore;
ArrayAdapter adapter;
    ListView emaillist;
    ListView scorelist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        db = new DatabaseHelper(this);
        listEmail = new ArrayList<>();
        listScore= new ArrayList<>();
        emaillist = findViewById(R.id.emaillist);
        scorelist = findViewById(R.id.scorelist);
        viewData();
    }

    private void viewData() {
        Cursor cursor = db.scoreboard();
        if (cursor.getCount()==0)
        {
            Toast.makeText(getApplicationContext(), "No records !", Toast.LENGTH_SHORT).show();
        }else{
            if(cursor.moveToFirst()) {
                do {
                    listEmail.add(cursor.getString(cursor.getColumnIndexOrThrow("email")));
                    listScore.add(cursor.getString(cursor.getColumnIndexOrThrow("score")));
                }
                while (cursor.moveToNext());
            }
          ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listEmail);
            emaillist.setAdapter(adapter);
            ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listScore);
            scorelist.setAdapter(adapter2);

        }
    }
}