package com.example.sudhe.quizgame3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void gameHandler (View view){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }


    public void gameScores (View view){
        Intent intent = new Intent(this, Score.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
