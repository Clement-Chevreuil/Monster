package com.example.monsterincity.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.monsterincity.DatabaseHandler;

public abstract class DAOBase {

    protected final static int VERSION = 1;
    protected final static String NOM = "Des_Monstres_Dans_La_Ville.db";

    protected SQLiteDatabase mDb = null;
    protected DatabaseHandler mHandler = null;

    public DAOBase(Context pContext) {
        this.mHandler = new DatabaseHandler(pContext, NOM, null, VERSION);
    }

    public SQLiteDatabase open() {
        mDb = mHandler.getWritableDatabase();
        return mDb;
    }

    public void close() {
        mDb.close();
    }

    public SQLiteDatabase getDb() {
        return mDb;
    }
}
