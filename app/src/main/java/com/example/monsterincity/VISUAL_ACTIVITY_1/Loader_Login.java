package com.example.monsterincity.VISUAL_ACTIVITY_1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.monsterincity.ACTIVITY.MainActivity;
import com.example.monsterincity.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Loader_Login#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Loader_Login extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Loader_Login() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Loader_Login.
     */
    // TODO: Rename and change types and number of parameters
    public static Loader_Login newInstance(String param1, String param2) {
        Loader_Login fragment = new Loader_Login();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_loader__login, container, false);

        int dureeTempsChargement = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Navigation.findNavController(v).navigate(R.id.mainActivity);
                /*finish(); fin de l'activite sauf que la c'est un fragment*/
            }
        }, dureeTempsChargement);


        return v;
    }
}