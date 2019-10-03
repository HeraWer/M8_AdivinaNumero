package com.example.search_number;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Player p = new Player();
    String resultado = new String();
    ArrayList<Player> listaP = new ArrayList<Player>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int nRandom = new Random().nextInt(100) + 1;
        final EditText introTexto = findViewById(R.id.introTexto);
        final TextView tv = findViewById(R.id.seguimiento);

        Button boton = findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String intento = introTexto.getText().toString();
                String pista = null;
                CharSequence text = pista;

                if (Integer.parseInt(intento) > nRandom) {
                    pista = "Intenta un numero mas pequeño";
                    p.contadorIntentos++;
                    tv.setText("Numero de intentos: " + p.contadorIntentos);
                } else if (Integer.parseInt(intento) < nRandom) {
                    pista = "Intenta un numero mas grande";
                    p.contadorIntentos++;;
                    tv.setText("Numero de intentos: " + p.contadorIntentos);
                } else if (Integer.parseInt(intento) == nRandom) {
                    p.contadorIntentos++;
                    openDialog();
                }
                Toast.makeText(MainActivity.this, pista, Toast.LENGTH_LONG).show();
                introTexto.getText().clear();


            }
        });
    }

    public void openSecondActivity(View view) {
        Intent in = new Intent(MainActivity.this, SecondActivity.class);
        in.putExtra("Manolo", p.contadorIntentos);
        in.putExtra("N", p.jPlayer);
        startActivity(in);
    }

    public void openDialog(){
        Dialogo d = new Dialogo();
        d.show(getSupportFragmentManager(), "Para el raking");
    }


}
