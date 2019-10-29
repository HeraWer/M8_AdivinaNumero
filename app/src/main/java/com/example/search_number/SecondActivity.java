package com.example.search_number;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SecondActivity extends AppCompatActivity {

    static ArrayList<Player> listP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        readFile();
        showData();
    }

    public void readFile(){
        listP = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("ranking.txt")));
            String line;
            while((line = br.readLine()) != null){
                String[] palabra = line.split(",");
                listP.add(new Player(palabra[0], Integer.parseInt(palabra[1])));
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showData(){
        Collections.sort(listP);
        ListView lv = findViewById(R.id.listRecord);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, listP);
        lv.setAdapter(adapter);
    }

}
