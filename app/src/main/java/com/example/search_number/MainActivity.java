package com.example.search_number;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int contador = 0;

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
                    contador++;
                    tv.setText("Numero de intentos: " + contador);
                } else if (Integer.parseInt(intento) < nRandom) {
                    pista = "Intenta un numero mas grande";
                    contador++;
                    tv.setText("Numero de intentos: " + contador);
                } else if (Integer.parseInt(intento) == nRandom) {
                    contador++;
                }
                Toast.makeText(MainActivity.this, pista, Toast.LENGTH_LONG).show();
                introTexto.getText().clear();


            }
        });
    }

    public void openSecondActivity(View view) {
        Intent in = new Intent(MainActivity.this, SecondActivity.class);
        in.putExtra("Manolo", contador);
        startActivity(in);
    }


}
