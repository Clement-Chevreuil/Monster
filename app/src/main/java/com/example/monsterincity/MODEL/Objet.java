package com.example.monsterincity.MODEL;

public class Objet {

    public int idObjet;
    private String name;
    public String attribut;
    public String description;
    public int gain;
    public int type;
    public int cout;



    public Objet(String name, String attribut,  int gain, int type,int cout, String description) {
        this.name = name;
        this.attribut = attribut;
        this.description = description;
        this.gain = gain;
        this.type = type;
        this.cout = cout;
    }

    public Objet(int idObjet) {
        this.idObjet = idObjet;
    }

    public Objet() {}

    public int getCout() { return cout; }

    public void setCout(int cout) { this.cout = cout; }

    public int getIdObjet() {
        return idObjet;
    }

    public void setIdObjet(int idObjet) {
        this.idObjet = idObjet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttribut() {
        return attribut;
    }

    public void setAttribut(String attribut) {
        this.attribut = attribut;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getGain() {
        return gain;
    }

    public void setGain(int gain) {
        this.gain = gain;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
