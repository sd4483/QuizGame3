package com.example.sudhe.quizgame3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sudhe on 19-05-2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "scoreManager";
    private static final String TABLE_SCORE = "score_table";
    private static final String KEY_ID = "id";
    private static final String KEY_SCORE = "score";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_SCORE_TABLE ="CREATE TABLE " + TABLE_SCORE + " (" +
                KEY_ID + " INTEGER PRIMARY KEY," + KEY_SCORE + " TEXT"
                + ")";

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORE);
        onCreate(db);
    }

    void addScore(Score score){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SCORE, score.getGame_score());

        db.insert(TABLE_SCORE, null, values);
        db.close();
    }

    Score getScore(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SCORE, new String[] {KEY_ID, KEY_SCORE}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        Score score =  new Score(Integer.parseInt(cursor.getString(0)), cursor.getString(1));
        return score;
    }

    public List<Score> getAllScores(){
        List<Score> scoreList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_SCORE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do{
                Score score = new Score();
                score.setId(Integer.parseInt(cursor.getString(0)));
                score.setGame_score(cursor.getString(1));

                scoreList.add(score);
            }while (cursor.moveToNext());
        }
        return scoreList;
    }
    public int updatescore(Score score){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SCORE, score.getGame_score());

        return db.update(TABLE_SCORE, values, KEY_ID + "=?",
                new String[]{String.valueOf(score.getId())});
    }
    public void deletescore(Score score){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SCORE, KEY_ID + "=?",
                new String[]{String.valueOf(score.getId())});
        db.close();
    }

    public int getScoreCount(){
        String countQuery = "SELECT  * FORM " + TABLE_SCORE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }
}
