package com.example.monsterincity.MODEL;




public class User {

    public int idUser;

    private String pseudo;

    public String password;

    public User(int idUser, String pseudo, String password) {
        super();
        this.idUser = idUser;
        this.pseudo = pseudo;
        this.password = password;

    }

    public User(String pseudo, String password) {
        super();
        this.pseudo = pseudo;
        this.password = password;

    }

    public User(String pseudo) {
        super();
        this.pseudo = pseudo;
    }

    public User() {super();}

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


}
