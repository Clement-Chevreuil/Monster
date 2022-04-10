package com.example.monsterincity.MODEL;

public class Character {

    public int idCharacter;

    private String name;

    public int hp_max;

    public int hp;

    public int atk;

    public Character(int idCharacter, String name, int hp, int atk) {
        this.idCharacter = idCharacter;
        this.name = name;
        this.hp = hp;
        this.atk = atk;
    }

    public Character(int idCharacter, String name,int hp_max, int hp, int atk) {
        this.idCharacter = idCharacter;
        this.name = name;
        this.hp_max = hp_max;
        this.hp = hp;
        this.atk = atk;
    }

    public Character(String name,int hp_max, int hp, int atk) {
        this.name = name;
        this.hp_max = hp_max;
        this.hp = hp;
        this.atk = atk;
    }

    public Character(String name, int hp, int atk) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
    }

    public Character(int idCharacter) {
        this.idCharacter = idCharacter;
    }

    public Character() {
    }

    public int getHp_max() {
        return hp_max;
    }

    public void setHp_max(int hp_max) {
        this.hp_max = hp_max;
    }

    public int getIdCharacter() {
        return idCharacter;
    }

    public void setIdCharacter(int idCharacter) {
        this.idCharacter = idCharacter;
    }

    public String getName() {
        return name;
    }
    public String getName2() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    @Override
    public String toString() {
        return "Character{" +
                "idCharacter=" + idCharacter +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", atk=" + atk +
                '}';
    }


}
