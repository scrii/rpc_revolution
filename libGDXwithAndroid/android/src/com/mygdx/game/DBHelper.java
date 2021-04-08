package com.mygdx.game;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "User";
    public static final String TABLE_CONTACTS = "square";
    public static final String KEY_ID = "_id";
    public static final String KEY_NICKNAME = "nickname";
    public static final String KEY_TEXTMESSAGE = "textmessage";
    public static final String KEY_MONEY = "money";
    public static final String KEY_ELBRIUM = "elbrium";
    public static final String KEY_SPEED = "speed";
    public static final String KEY_ATTACK = "attack";
    public static final String KEY_HEALTH = "health";
    public static final String KEY_PROTECT = "protect";
    public static final String KEY_COLORBACKGROUND = "colorbackground";
    public static final String KEY_COLORFRONT = "colorfront";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_CONTACTS + "(" + KEY_ID
                + " integer primary key," + KEY_NICKNAME + " text," + KEY_TEXTMESSAGE + " text," + KEY_MONEY + " real," + KEY_ELBRIUM + " real," + KEY_SPEED + " integer," + KEY_ATTACK + " integer," + KEY_HEALTH + " integer,"
        + KEY_PROTECT + " integer," + KEY_COLORBACKGROUND + " text," + KEY_COLORFRONT + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
