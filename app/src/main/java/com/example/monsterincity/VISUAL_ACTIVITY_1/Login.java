package com.example.monsterincity.VISUAL_ACTIVITY_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.monsterincity.DAO.UserDAO;
import com.example.monsterincity.MODEL.User;
import com.example.monsterincity.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Login#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Login extends Fragment {


    EditText pseudo, password;
    TextView erreur;
    Button connexion;
    Button but;
    UserDAO userDAO;

    public Login() {
        // Required empty public constructor
    }


    public static Login newInstance(String param1) {
        Login fragment = new Login();
        Bundle args = new Bundle();
        args.putString("ah", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userDAO = new UserDAO(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_login, container, false);

        erreur = v.findViewById(R.id.erreur);
        pseudo = v.findViewById(R.id.login_pseudo);
        password = v.findViewById(R.id.login_password);
        connexion = v.findViewById(R.id.login_connexion);
        connexion.setOnClickListener(connexionApp);

        but = (Button) v.findViewById(R.id.login_connexion);
        but.setOnClickListener(connexionApp);
        return v;
    }

    View.OnClickListener connexionApp = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            //View itemDetailFragmentContainer = v.findViewById(R.id.fr);

            String pseudoS = pseudo.getText().toString();
            String passwordS = password.getText().toString();

            if(!pseudoS.isEmpty() && !passwordS.isEmpty()) {
                User user = userDAO.connexion(pseudoS, passwordS);
                if(user.getPseudo() != null){
                    Bundle bundle = new Bundle();
                    bundle.putInt("idUser", user.getIdUser());
                    Navigation.findNavController(v).navigate(R.id.loader_Login);
                }
                else{ erreurConnexion(); }
            }
            else { erreurNonRemplie(); }


        }
    };

    public void erreurNonRemplie() {
        erreur.setText("veuillez remplir correctement les champs.");
    }
    public void erreurConnexion() {
        erreur.setText("Les identifiants ne sont pas les bons.");
    }
}