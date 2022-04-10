package com.example.monsterincity.aaFUTURE;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.monsterincity.MODEL.User;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private List<User> userList;
    private LayoutInflater inflater;
    private int idUtilisateur;

    public UserAdapter(Context context, List<User> userList)
    {
        this.context = context;
        this.userList = userList;
        this.inflater = LayoutInflater.from(context);
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, final ViewGroup parent) {
/*        view = inflater.inflate(R.layout.adapter_item_boutique, null);
        User unUtilisateur = (User) getItem(i);
        String nameUser = unUtilisateur.getPseudo();
        String idUser = String.valueOf(unUtilisateur.getIdUser());


        //get name concour view
        TextView itemNameView = view.findViewById(R.id.userName);
        itemNameView.setText(nameUser);
        //get name festival view
        TextView itemPriceView = view.findViewById(R.id.userPassword);
        itemPriceView.setText(idUser);*/
        return view;

    }
}
