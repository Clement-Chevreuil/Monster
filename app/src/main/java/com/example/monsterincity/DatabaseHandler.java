package com.example.monsterincity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String nameTableUser = "User";
    private static final String idUser = "id_user";
    private static final String pseudo = "pseudo";
    private static final String password = "password";

    private static final String nameTableCharacter = "Character";
    private static final String idCharacter = "id_character";
    private static final String name = "name";
    private static final String hp_max = "hp_max";
    private static final String hp = "hp";
    private static final String atk = "atk";

    private static final String nameTableObjet = "Objet";
    private static final String idObjet = "id_objet";
    private static final String nameObjet = "name_objet";
    private static final String descriptionObjet = "description_objet";
    private static final String attributObjet = "attribut_objet";
    private static final String gainObjet = "gain_objet";
    private static final String typeObjet = "type_objet";
    private static final String coutObjet = "cout_objet";


    private static final String reqCreateObjet = "CREATE TABLE " + nameTableObjet + " (" + idObjet + " INTEGER PRIMARY KEY AUTOINCREMENT," + nameObjet + " TEXT," + attributObjet + " TEXT," + gainObjet +  " INTEGER," + typeObjet + " INTEGER," + coutObjet + " INTEGER," + descriptionObjet + " TEXT);";
    private static final String reqCreateUser = "CREATE TABLE " + nameTableUser + " (" + idUser + " INTEGER PRIMARY KEY AUTOINCREMENT," + pseudo + " TEXT," + password + " TEXT);";
    private static final String reqCreateCharacter = "CREATE TABLE " + nameTableCharacter + " (" + idCharacter + " INTEGER PRIMARY KEY AUTOINCREMENT," + name + " TEXT," + hp_max + " INTEGER," + hp + " INTEGER," + atk + " INTEGER);";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("test base", "insertion " + reqCreateUser);
        Log.i("test base", "insertion " + reqCreateCharacter);
        Log.i("test base", "insertion " + reqCreateObjet);
        db.execSQL(reqCreateUser);
        db.execSQL(reqCreateCharacter);
        db.execSQL(reqCreateObjet);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String reqSuppUser = "DROP TABLE IF EXISTS " + nameTableUser + reqCreateUser;
        String reqSuppCharacter = "DROP TABLE IF EXISTS " + nameTableCharacter + reqCreateCharacter;
        String reqSuppObject =  "DROP TABLE IF EXISTS " + nameTableObjet + reqCreateObjet;
        db.execSQL(reqSuppUser);
        db.execSQL(reqSuppCharacter);
        db.execSQL(reqSuppObject);
        onCreate(db);
    }
}
