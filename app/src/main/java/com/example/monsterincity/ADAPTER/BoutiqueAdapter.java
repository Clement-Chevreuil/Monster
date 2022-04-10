package com.example.monsterincity.ADAPTER;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.monsterincity.MODEL.Objet;
import com.example.monsterincity.R;

import java.util.List;

public class BoutiqueAdapter extends BaseAdapter {
    private Context context;
    private List<Objet> objetList;
    private LayoutInflater inflater;
    private int idUtilisateur;

    public BoutiqueAdapter(Context context, List<Objet> objetList)
    {
        this.context = context;
        this.objetList = objetList;
        this.inflater = LayoutInflater.from(context);
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public int getCount() {
        return objetList.size();
    }

    @Override
    public Object getItem(int position) {
        return objetList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, final ViewGroup parent) {
        view = inflater.inflate(R.layout.item_objet, null);
        Objet objet = (Objet) getItem(i);

        String idUser = String.valueOf(objet.getIdObjet());
        String nameObjet = objet.getName();
        String descritpionObjet = objet.getDescription();
        String gainObjet = String.valueOf(objet.getGain());
        String attributObjet = objet.getAttribut();
        String typeObjet = String.valueOf(objet.getType());
        String coutObjet = String.valueOf(objet.getCout());



        TextView itemNameView = view.findViewById(R.id.name_objet);
        itemNameView.setText(nameObjet);

        TextView itemgainView = view.findViewById(R.id.gain_objet);
        itemgainView.setText(String.valueOf(gainObjet) + " " + attributObjet);

        TextView itemCoutView = view.findViewById(R.id.cout_objet);
        itemCoutView.setText(String.valueOf(coutObjet) + "$");

        return view;
    }
}
