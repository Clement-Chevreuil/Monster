package com.example.monsterincity.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Collections;

import com.example.monsterincity.MODEL.Character;

public class CharacterDAO extends DAOBase {

    private static final String nameTableCharacter = "Character";
    private static final String idCharacter = "id_character";
    private static final String name = "name";
    private static final String hp = "hp";
    private static final String hp_max = "hp_max";
    private static final String atk = "atk";

    private static final String reqCreateCharacter = "CREATE TABLE " + nameTableCharacter + " (" + idCharacter + " INTEGER PRIMARY KEY AUTOINCREMENT," + name + " TEXT," + hp_max + " INTEGER," + hp + " INTEGER," + atk + " INTEGER);";
    public static final String TABLE_DROP =  "DROP TABLE IF EXISTS " + nameTableCharacter + ";";

    public CharacterDAO(Context pContext) {
        super(pContext);
        fakeData();
    }


    public void add(Character character) {

        ContentValues values = new ContentValues();

        values.put(name, character.getName());
        values.put(hp_max, character.getHp_max());
        values.put(hp, character.getHp());
        values.put(atk, character.getAtk());

        mDb.insert(nameTableCharacter, null, values);
    }

    /**
     * @param id l'identifiant du métier à supprimer
     */
    public void delete(long id) {
        mDb.delete(nameTableCharacter, idCharacter + " = ?", new String[] {String.valueOf(id)});
    }

    /**
     * @param m le métier modifié
     */
    public void update(Character m) {
        ContentValues value = new ContentValues();
        value.put(name, m.getName());
        mDb.update(nameTableCharacter, value, idCharacter  + " = ?", new String[] {String.valueOf(m.getIdCharacter())});
    }

    public void fakeData() {
        this.open();
        Character character = new Character("Rapha",12, 12, 2);
        Character character2 = new Character("Ell",12,  12, 1);

        ContentValues values = new ContentValues();
        ContentValues values2 = new ContentValues();

        values.put(name, character.getName());
        values.put(hp_max, character.getHp_max());
        values.put(hp, character.getHp());
        values.put(atk, character.getAtk());


        values2.put(name, character2.getName());
        values2.put(hp_max, character2.getHp_max());
        values2.put(hp, character2.getHp());
        values2.put(atk, character2.getAtk());


        mDb.insert(nameTableCharacter, null, values);
        mDb.insert(nameTableCharacter, null, values2);

        this.close();
    }

    /**
     * @param id l'identifiant du métier à récupérer
     */
    public ArrayList<Character> select(int id) {
        this.open();
            ArrayList<Character> characterList = new ArrayList<Character>();
            Cursor unCurseur = mDb.rawQuery("SELECT * FROM Character WHERE id_character =  "+id+" ;", null);

            if (unCurseur.moveToFirst()) {
                do {
                    Character character = new Character();

                    character.setIdCharacter(unCurseur.getInt(unCurseur.getColumnIndex(idCharacter)));
                    character.setHp_max(unCurseur.getInt(unCurseur.getColumnIndex(hp_max)));
                    character.setHp(unCurseur.getInt(unCurseur.getColumnIndex(hp)));
                    character.setAtk(unCurseur.getInt(unCurseur.getColumnIndex(atk)));
                    character.setName(unCurseur.getString(unCurseur.getColumnIndex(name)));
                    characterList.add(character);
                }
                while (unCurseur.moveToNext());
                Collections.shuffle(characterList);
            }
            this.close();
            return characterList;

    }

    public Character selectById(int id) {
        this.open();
        Character character = new Character();
        Cursor unCurseur = mDb.rawQuery("SELECT * FROM Character WHERE id_character =  "+id+" ;", null);

        if(unCurseur.getCount() == 0)
        {
            character.setIdCharacter(0);
            character.setAtk(0);
            character.setHp(0);
            character.setHp_max(0);
            character.setName("unknow");
        }

        if (unCurseur.moveToFirst()) {

            character = new Character();
            character.setIdCharacter(unCurseur.getInt(unCurseur.getColumnIndex(idCharacter)));
            character.setHp_max(unCurseur.getInt(unCurseur.getColumnIndex(hp_max)));
            character.setHp(unCurseur.getInt(unCurseur.getColumnIndex(hp)));
            character.setAtk(unCurseur.getInt(unCurseur.getColumnIndex(atk)));
            character.setName(unCurseur.getString(unCurseur.getColumnIndex(name)));
        }
        this.close();
        return character;
    }
}
