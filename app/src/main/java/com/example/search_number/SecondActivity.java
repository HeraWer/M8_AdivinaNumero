package com.example.search_number;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;

public class SecondActivity extends AppCompatActivity {

    static ArrayList<Player> listP = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // LLAMAMOS AL COLLECTIONS.SORT PARA ORDENAR LA LISTA CON EL METODO DEFINIDO EN EL PLAYER
        Collections.sort(listP);

        // PARA ADAPTAR LA LISTA A LA LIST VIEW
        ListView lv = findViewById(R.id.listRecord);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, listP);
        lv.setAdapter(adapter);




    }
}
