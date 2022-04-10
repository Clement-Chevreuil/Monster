package com.example.monsterincity.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.monsterincity.MODEL.User;

import java.util.ArrayList;
import java.util.Collections;

public class UserDAO extends DAOBase {

    private static final String nameTableUser = "User";
    private static final String idUser = "id_user";
    private static final String pseudo = "pseudo";
    private static final String password = "password";

    private static final String reqCreateUser = "CREATE TABLE " + nameTableUser + " (" + idUser + " INTEGER PRIMARY KEY AUTOINCREMENT," + pseudo + " TEXT," + password + " TEXT);";

    public static final String TABLE_DROP =  "DROP TABLE IF EXISTS " + nameTableUser + ";";

    public UserDAO(Context pContext) {
        super(pContext);
        testUsers();
    }

    public void testUsers() {
        ArrayList<User> allUser = new ArrayList<User>();
        this.open();
        Cursor unCurseur = mDb.rawQuery("SELECT * FROM User;", null);
        if (unCurseur.moveToFirst()) {

        }
        else
        {
            createUser();
        }
        this.close();

    }

    public void add(User user) {

        ContentValues values = new ContentValues();

        values.put(pseudo, user.getPseudo());
        values.put(password, user.getPassword());

        mDb.insert(nameTableUser, null, values);
    }

    /**
     * @param id l'identifiant du métier à supprimer
     */
    public void delete(long id) {
        mDb.delete(nameTableUser, idUser + " = ?", new String[] {String.valueOf(id)});
    }

    /**
     * @param m le métier modifié
     */
    public void update(User m) {
        ContentValues value = new ContentValues();
        value.put(pseudo, m.getPseudo());
        mDb.update(nameTableUser, value, idUser  + " = ?", new String[] {String.valueOf(m.getIdUser())});
    }

    public void fakeData() {
        this.open();
        User user = new User("c", "c");
        ContentValues values = new ContentValues();

        values.put(pseudo, user.getPseudo());
        values.put(password, user.getPassword());

        mDb.insert(nameTableUser, null, values);
        this.close();
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> allUser = new ArrayList<User>();

        /*User user = new User();
        user.setIdUser(1);
        user.setPseudo("kev");
        allUser.add(user);

        User user2 = new User();
        user2.setIdUser(2);
        user2.setPseudo("adam");
        allUser.add(user2);

        User user3 = new User();
        user3.setIdUser(3);
        user3.setPseudo("clem");
        allUser.add(user3);*/
        this.open();
        Cursor unCurseur = mDb.rawQuery("SELECT * FROM User;", null);
        if (unCurseur.moveToFirst()) {
            do {
                User user = new User();
                user.setIdUser(unCurseur.getInt(unCurseur.getColumnIndex(idUser)));
                user.setPseudo(unCurseur.getString(unCurseur.getColumnIndex(pseudo)));
                allUser.add(user);
            }
            while (unCurseur.moveToNext());
            Collections.shuffle(allUser);
        }
        else
        {
            createUser();
        }
        this.close();
        return allUser;

    }

    public User connexion(String pseudo2, String password2){

        this.open();
        Cursor unCurseur = mDb.rawQuery("SELECT * FROM User WHERE pseudo = '" + pseudo2 + "' AND password = '" + password2 + "' ;", null);
        User user = new User();
        int nbrRec = unCurseur.getCount();
        if (nbrRec != 0)
        {
            unCurseur.moveToFirst();
            user.setIdUser(unCurseur.getInt(unCurseur.getColumnIndex(idUser)));
            user.setPseudo(unCurseur.getString(unCurseur.getColumnIndex(pseudo)));
        }
        else
        {
            User user2 = new User("a","a" );
            add(user2);
        }

        this.close();
        return user;
    }

    public void createUser(){

        this.open();
        User user2 = new User("a","a" );
        add(user2);
        this.close();
    }

    /**
     * @param id l'identifiant du métier à récupérer
     */
    /*public User select(long id) {
        // CODE
    }*/
}
