package com.example.monsterincity.VISUAL_ACTIVITY_3;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.monsterincity.DAO.CharacterDAO;
import com.example.monsterincity.DAO.UserDAO;
import com.example.monsterincity.R;

import com.example.monsterincity.MODEL.Character;

public class Fight extends AppCompatActivity {

    private Button atk, potion;
    private ProgressBar ennemieHP, characterHP;
    private TextView informations, ennemieName, characterName, numberEnnemieHP, numberCharacterHP;
    private RatingBar ennemieRating;
    Character character, ennemie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        UserDAO testUser = new UserDAO(getApplicationContext());
        CharacterDAO testCharacter = new CharacterDAO(getApplicationContext());

        character = testCharacter.selectById(1);
        ennemie = testCharacter.selectById(2);

        atk = findViewById(R.id.btnAttack);
        atk.setOnClickListener(atkEnnemie);

        potion = findViewById(R.id.btnPotion);
        potion.setOnClickListener(heal);

        numberEnnemieHP = findViewById(R.id.numberEnnemieHP);
        numberCharacterHP = findViewById(R.id.numberCharacterHP);
        ennemieHP = findViewById(R.id.ennemieHP);
        characterHP = findViewById(R.id.playerHP);
        ennemieName = findViewById(R.id.ennemieName);
        characterName = findViewById(R.id.playerName);
        informations = findViewById(R.id.informations);
        ennemieRating = findViewById(R.id.stars);

        ennemieName.setText(ennemie.getName());
        characterName.setText(character.getName());

        ennemieRating.setRating(2);
        ennemieRating.setNumStars(5);

        numberEnnemieHP.setText(ennemie.getHp() + "/" + ennemie.getHp_max());
        ennemieHP.setProgress(ennemie.getHp()*100/ennemie.getHp_max());

        numberCharacterHP.setText(ennemie.getHp() + "/" + ennemie.getHp_max());
        characterHP.setProgress(ennemie.getHp()*100/ennemie.getHp_max());

    }

    private View.OnClickListener atkEnnemie = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            atk.setEnabled(false);
            potion.setEnabled(false);
            int timer = affichageTextAvectextApres("Vous avez attaqué");
            ennemie.setHp(ennemie.getHp() - character.getAtk());


            if(ennemie.getHp() <= 0)
            {
                ennemieHP.setProgress(0);
                numberEnnemieHP.setText("0/" + ennemie.getHp_max());
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        affichageText("Vous avez tué votre ennemie vous avez gagné ...");
                        atk.setEnabled(true);
                        finish();
                    }
                }, 1500);
            }
            else
            {
                ennemieHP.setProgress(ennemie.getHp() * 100 / ennemie.getHp_max());
                numberEnnemieHP.setText(ennemie.getHp() + "/" + ennemie.getHp_max());
                attaqueEnnemie(timer);

            }

        }
    };

    private View.OnClickListener heal = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(character.getHp_max() == character.getHp())
            {
                affichageText("Vos PV sont déjà au maximum");
            }
            else
            {
                atk.setEnabled(false);
                potion.setEnabled(false);
                int timer = affichageTextAvectextApres("Vous avez gagné 10 PV");

                if(character.getHp_max() < character.getHp() + 10)
                {
                    character.setHp(character.getHp_max());
                    characterHP.setProgress(100);
                    numberCharacterHP.setText(character.getHp() + "/" + character.getHp_max());
                }
                else{
                    character.setHp(character.getHp() + 10);
                    characterHP.setProgress(character.getHp() * 100 / character.getHp_max());
                    numberCharacterHP.setText(character.getHp() + "/" + character.getHp_max());
                }

                attaqueEnnemie(timer);
            }

        }
    };



    public void attaqueEnnemie(int timer)
    {
        String text1 = "Attaque ennemie vous perdez " + ennemie.getAtk() + " points de vie";
        String text2 = "A votre tours";

        int text2duration = text1.length() * 50 + 1500;

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {

                character.setHp(character.getHp() - ennemie.getAtk());
                characterHP.setProgress(character.getHp() * 100 / character.getHp_max());
                numberCharacterHP.setText(character.getHp() + "/" + character.getHp_max());

                Thread thread = new Thread() {
                    int i;
                    @Override
                    public void run() {
                        try {
                            for (i = 0; i < text1.length(); i++) { // use your variable text.leght()
                                Thread.sleep(50);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        informations.setText(text1.substring(0, i));
                                    }
                                });
                            }
                        }
                        catch (InterruptedException e) {}
                    }
                };
                thread.start();

                Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    public void run() {
                        Thread thread = new Thread() {
                            int i;
                            @Override
                            public void run() {
                                try {
                                    for (i = 0; i < text2.length(); i++) { // use your variable text.leght()
                                        Thread.sleep(50);
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                informations.setText(text2.substring(0, i));
                                            }
                                        });
                                    }
                                }
                                catch (InterruptedException e) {}
                            }
                        };
                        thread.start();
                        atk.setEnabled(true);
                        potion.setEnabled(true);
                    }
                }, text2duration);
            }
        }, timer);
    }



    public void affichageText(String text)
    {
        Thread thread = new Thread() {
            int i;
            @Override
            public void run() {
                try {
                    for (i = 0; i < text.length(); i++) { // use your variable text.leght()
                        Thread.sleep(50);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                informations.setText(text.substring(0, i));
                            }
                        });
                    }
                }
                catch (InterruptedException e) {}
            }
        };
        thread.start();
    }




    public int affichageTextAvectextApres(String text)
    {
        Thread thread = new Thread() {
            int i;
            @Override
            public void run() {
                try {
                    for (i = 0; i < text.length(); i++) { // use your variable text.leght()
                        Thread.sleep(50);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                informations.setText(text.substring(0, i));
                            }
                        });
                    }
                }
                catch (InterruptedException e) {}
            }
        };
        thread.start();
        return text.length() * 50 + 1500;
    }







    public void attaqueEnnemie2()
    {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                affichageText("Attaque ennemie vous perdez " + ennemie.getAtk() + " points de vie");
                character.setHp(character.getHp() - ennemie.getAtk());
                characterHP.setProgress(character.getHp() * 100 / character.getHp_max());
                numberCharacterHP.setText(character.getHp() + "/" + character.getHp_max());

                Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    public void run() {
                        affichageText("A votre tours");
                        atk.setEnabled(true);
                        potion.setEnabled(true);
                    }
                }, 1500);
            }
        }, 1500);
    }

}