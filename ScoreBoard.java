package com.example.sudhe.quizgame3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreBoard extends AppCompatActivity {
    TextView textView;

    String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        textView = (TextView) findViewById(R.id.textView);

        DatabaseHelper db = new DatabaseHelper(this);

        db.addScore(new Score());
    }
}
