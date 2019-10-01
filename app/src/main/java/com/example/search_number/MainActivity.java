package com.example.search_number;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int nRandom = new Random().nextInt(100) + 1;
        final EditText introTexto = findViewById(R.id.introTexto);

        Button boton = findViewById(R.id.boton);
        Button raking = findViewById(R.id.ranking);
        final TextView tv = findViewById(R.id.seguimiento);
        final int[] contador = {0};

        raking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String intento = introTexto.getText().toString();
                String pista = null;


                if(Integer.parseInt(intento) > nRandom){
                    pista = "Intenta un numero mas pequeño";
                    contador[0]++;
                    tv.setText("Numero de intentos: " + contador[0]);
                }else if (Integer.parseInt(intento) < nRandom) {
                    pista = "Intenta un numero mas grande";
                    contador[0]++;
                    tv.setText("Numero de intentos: " + contador[0]);
                }else if(Integer.parseInt(intento) == nRandom){

                }

                CharSequence text = pista;
                int duration = Toast.LENGTH_LONG;

                Toast.makeText(MainActivity.this, text, duration).show();
                introTexto.getText().clear();


            }
        });
    }
}
