package com.example.sudhe.quizgame3;

/**
 * Created by sudhe on 19-05-2017.
 */

public class Score {

    int id;
    String game_score;

    public Score(int i, String string, String cursorString){

    }

    public Score( String game_score){
        this.game_score = game_score;
    }

    public Score(int id, String game_score){
        this.id = id;
        this.game_score = game_score;
    }

    public Score() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGame_score() {
        return game_score;
    }

    public void setGame_score(String game_score) {
        this.game_score = game_score;
    }
}
