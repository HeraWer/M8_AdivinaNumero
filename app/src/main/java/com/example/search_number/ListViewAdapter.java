package com.example.search_number;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter {

    public ListViewAdapter(Context c, ArrayList<Player> players){
        super(c, 0, players);
    }

    public View getView(int position, View view, ViewGroup parent) {

        final  Player player = (Player) getItem(position);

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.activity_second_adapter, parent, false);
        }

        TextView nomPlayer = view.findViewById(R.id.nomTextView);
        TextView intentosPlayer = view.findViewById(R.id.intentosTextView);
        ImageView fotoPlayer = view.findViewById(R.id.perfilImageView);


        fotoPlayer.setImageURI(player.getFotoRanking());
        nomPlayer.setText("Nombre: " + player.getjPlayer());
        intentosPlayer.setText("Intentos: " + String.valueOf(player.getContadorIntentos()));


        return view;

    }
}
