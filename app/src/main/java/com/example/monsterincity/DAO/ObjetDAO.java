package com.example.monsterincity.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.monsterincity.MODEL.Objet;

import java.util.ArrayList;
import java.util.Collections;

public class ObjetDAO extends DAOBase {

    private static final String nameTableObjet = "Objet";
    private static final String idObjet = "id_objet";
    private static final String nameObjet = "name_objet";
    private static final String descriptionObjet = "description_objet";
    private static final String attributObjet = "attribut_objet";
    private static final String gainObjet = "gain_objet";
    private static final String typeObjet = "type_objet";
    private static final String coutObjet = "cout_objet";


    private static final String reqCreateObjet = "CREATE TABLE " + nameTableObjet + " (" + idObjet + " INTEGER PRIMARY KEY AUTOINCREMENT," + nameObjet + " TEXT," + attributObjet + " TEXT," + gainObjet +  " INTEGER," + typeObjet +" INTEGER," + coutObjet + " INTEGER," + descriptionObjet + " TEXT);";

    public static final String TABLE_DROP =  "DROP TABLE IF EXISTS " + nameTableObjet + ";";

    public ObjetDAO(Context pContext) {
        super(pContext);
        fakeData();

    }
    public void add(Objet objet) {

        ContentValues values = new ContentValues();

        values.put(nameObjet, objet.getName());
        values.put(descriptionObjet, objet.getDescription());
        values.put(gainObjet, objet.getGain());
        values.put(attributObjet, objet.getAttribut());
        values.put(typeObjet, objet.getType());
        mDb.insert(nameTableObjet, null, values);
    }

    /**
     * @param id l'identifiant du métier à supprimer
     */
    public void delete(long id) {
        mDb.delete(nameTableObjet, idObjet + " = ?", new String[] {String.valueOf(id)});
    }

    /**
     * @param m le métier modifié
     */
    public void update(Objet m) {
        ContentValues value = new ContentValues();
        value.put(nameObjet, m.getName());
        value.put(descriptionObjet, m.getDescription());
        value.put(gainObjet, m.getGain());
        value.put(attributObjet, m.getAttribut());
        value.put(typeObjet, m.getType());
        value.put(coutObjet, m.getCout());
        mDb.update(nameTableObjet, value, idObjet  + " = ?", new String[] {String.valueOf(m.getIdObjet())});
    }

    public void fakeData() {
        this.open();
        Objet objet = new Objet("Potion", "HP", 10, 1,10, "soigne 10 de vos PV");
        ContentValues values = new ContentValues();

        values.put(nameObjet, objet.getName());
        values.put(descriptionObjet, objet.getDescription());
        values.put(gainObjet, objet.getGain());
        values.put(attributObjet, objet.getAttribut());
        values.put(typeObjet, objet.getType());
        values.put(coutObjet, objet.getCout());
        mDb.insert(nameTableObjet, null, values);
        this.close();
    }

    public ArrayList<Objet> allObjet() {
        ArrayList<Objet> allObjet = new ArrayList<Objet>();

        this.open();
        Cursor unCurseur = mDb.rawQuery("SELECT * FROM Objet;", null);
        if (unCurseur.moveToFirst()) {
            do {
                Objet objet = new Objet();
                objet.setName(unCurseur.getString(unCurseur.getColumnIndex(nameObjet)));
                objet.setAttribut(unCurseur.getString(unCurseur.getColumnIndex(attributObjet)));
                objet.setIdObjet(unCurseur.getInt(unCurseur.getColumnIndex(idObjet)));
                objet.setDescription(unCurseur.getString(unCurseur.getColumnIndex(descriptionObjet)));
                objet.setGain(unCurseur.getInt(unCurseur.getColumnIndex(gainObjet)));
                objet.setType(unCurseur.getInt(unCurseur.getColumnIndex(typeObjet)));
                objet.setCout(unCurseur.getInt(unCurseur.getColumnIndex(coutObjet)));
                allObjet.add(objet);
            }
            while (unCurseur.moveToNext());
            Collections.shuffle(allObjet);
        }
        this.close();
        return allObjet;

    }

    /**
     * @param id l'identifiant du métier à récupérer
     */
    /*public User select(long id) {
        // CODE
    }*/
}
