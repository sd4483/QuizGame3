package com.example.sudhe.quizgame3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    Button answer1, answer2, answer3, answer4;

    ImageView QuestionImage;

    TextView score;

    List<CountryItem> list;

    List<Integer> scorelist;

    private int mScore = 0;

    Random r;

    int turn = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        r = new Random();

        QuestionImage = (ImageView)findViewById(R.id.QuestionImage);

        answer1 = (Button)findViewById(R.id.answer1);
        answer2 = (Button)findViewById(R.id.answer2);
        answer3 = (Button)findViewById(R.id.answer3);
        answer4 = (Button)findViewById(R.id.answer4);

        score = (TextView) findViewById(R.id.score);

        score.setText("Score: " + mScore);

        scorelist = new ArrayList();

        list = new ArrayList<>();

        for (int i=0; i < new DataBase().answers.length; i++){
            list.add(new CountryItem(new DataBase().answers[i], new DataBase().flags[i]));
        }

        Collections.shuffle(list);

        newQuestion(turn);

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer1.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())){
                    mScore++;
                    score.setText("Score: " + mScore);

                    if (turn < list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        gameOver();
                        scorelist.add(mScore);
                    }
                }else {
                    gameOver();
                }

            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer2.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())){
                    mScore++;
                    score.setText("Score: " + mScore);

                    if (turn < list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        gameOver();
                    }
                }else {
                    gameOver();
                }

            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer3.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())){
                    mScore++;
                    score.setText("Score: " + mScore);

                    if (turn < list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        gameOver();
                    }
                }else {
                    gameOver();
                }

            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer4.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())){
                    mScore++;
                    score.setText("Score: " + mScore);

                    if (turn < list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        gameOver();
                    }
                }else {
                    gameOver();
                }

            }
        });
    }

    private void newQuestion(int number){
        QuestionImage.setImageResource(list.get(number - 1).getImage());

        int correct_answer = r.nextInt(4) + 1;

        int firstButton = number - 1;
        int secondButton;
        int thirdButton;
        int fourthButton;

        switch (correct_answer){
            case 1:
                answer1.setText(list.get(firstButton).getName());

                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while (thirdButton == secondButton || thirdButton == firstButton);
                do{
                    fourthButton = r.nextInt(list.size());
                }while (fourthButton == thirdButton || fourthButton == secondButton || fourthButton == firstButton);

                answer2.setText(list.get(secondButton).getName());
                answer3.setText(list.get(thirdButton).getName());
                answer4.setText(list.get(fourthButton).getName());

                break;
            case 2:
                answer2.setText(list.get(firstButton).getName());

                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while (thirdButton == secondButton || thirdButton == firstButton);
                do{
                    fourthButton = r.nextInt(list.size());
                }while (fourthButton == thirdButton || fourthButton == secondButton || fourthButton == firstButton);

                answer1.setText(list.get(secondButton).getName());
                answer3.setText(list.get(thirdButton).getName());
                answer4.setText(list.get(fourthButton).getName());

                break;
            case 3:
                answer3.setText(list.get(firstButton).getName());

                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while (thirdButton == secondButton || thirdButton == firstButton);
                do{
                    fourthButton = r.nextInt(list.size());
                }while (fourthButton == thirdButton || fourthButton == secondButton || fourthButton == firstButton);

                answer2.setText(list.get(secondButton).getName());
                answer1.setText(list.get(thirdButton).getName());
                answer4.setText(list.get(fourthButton).getName());

                break;
            case 4:
                answer4.setText(list.get(firstButton).getName());

                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while (thirdButton == secondButton || thirdButton == firstButton);
                do{
                    fourthButton = r.nextInt(list.size());
                }while (fourthButton == thirdButton || fourthButton == secondButton || fourthButton == firstButton);

                answer2.setText(list.get(secondButton).getName());
                answer3.setText(list.get(thirdButton).getName());
                answer1.setText(list.get(fourthButton).getName());

                break;
        }


    }
    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(GameActivity.this);
        alertDialogBuilder
                .setMessage("Game Over! Your Score is " + mScore + "points.")
                .setCancelable(false)
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));

                            }
                        })
                .setNegativeButton("EXIT",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


}
