package com.example.search_number;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        MainActivity mA = new MainActivity();
        final TextView textViewRecords = findViewById(R.id.textViewRecords);
       textViewRecords.setText("");
       for(Player p : mA.listaP){
           textViewRecords.setText(textViewRecords.getText() + p.toString());
       }

    }
}
