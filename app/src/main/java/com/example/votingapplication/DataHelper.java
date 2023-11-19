package com.example.votingapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "hasilvoting.db";
    public static final int DATABASE_VERSION = 1;
    public DataHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + "Votes" + "(" +
                "id" + " INTEGER PRIMARY KEY," +
                "name" + " TEXT," +
                "candidate_id" + " INTEGER" + ")";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "Votes");
        onCreate(sqLiteDatabase);
    }

    public void addVote(Vote vote){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", vote.getName());
        contentValues.put("candidate_id", vote.getCandidate_ID());
        db.insert("Votes", null, contentValues);
        db.close();
    }
    public Vote getVote(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor
                = db.rawQuery("SELECT * FROM " + "Votes" + " WHERE " + "id" + " = '"+ id +"'", null);

        if (cursor.moveToFirst()) {
            return new Vote(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getInt(2)
            );
        }
        return null;
    }

    public Vote getVote (String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor
                = db.rawQuery("SELECT * FROM " + "Votes" + " WHERE " + "name" + " = '"+ name +"'", null);

        if (cursor.moveToFirst()) {
            return new Vote(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getInt(2)
            );
        }
        return null;
    }

    public ArrayList<Vote> getAllVotes(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Vote> voteArrayList = new ArrayList<Vote>();
        Cursor cursor
                = db.rawQuery("SELECT * FROM " + "Votes", null);

        if (cursor.moveToFirst()) {
            do {
                voteArrayList.add(new Vote(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getInt(2)
                ));
            } while (cursor.moveToNext());
            return voteArrayList;
        }

        return null;
    }

    public Integer getVoteAmount(int candidate_ID){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor
                = db.rawQuery("SELECT * FROM " + "Votes" + " WHERE " + "candidate_id" + " = '"+ candidate_ID +"'", null);
        return cursor.getCount();
    }
}

