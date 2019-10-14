package com.example.search_number;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Player p = new Player();
    private int nRandom = generarRandom(); // VARIABLE PARA GENERAR UN RANDOM
    private TextView tv; // VARIABLE PARA CREAR UN TEXTVIEW DONDE SE VERAN LOS INTENTOS
    private EditText introTexto; // VARIABLE PARA LEER LO QUE INTRODUCIMOS EN EL EDITTEXT DE INTENTOS
    private String nombreDialogo; // VARIABLE QUE RECOJO DEL DIALOGO
    private int contIntentos = 0; // VARIABLE PARA CONTAR INTENTOS

    // ON CREATE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        introTexto = findViewById(R.id.introTexto); // DECIMOS LA RUTA DE DONDE ESTA REFERENCIADO
        tv = findViewById(R.id.seguimiento); // DECIMOS LA RUTA DE DONDE ESTA REFERENCIADO

        Button boton = findViewById(R.id.boton); // BOTON PARA COMPROBAR EL NUMERO INTRODUCIDO
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String intento = introTexto.getText().toString(); // LEEMOS EL INTROTEXT Y LO GUARDAMOS EN UNA VARIABLE PARA HACER COMPROBACIONES
                String pista = null; // TEXTO QUE ESTARA EN EL TOAST A LA HORA DE COMPROBAR EL NUMERO ( MAS GRANDE O MAS PEQUEÑO )
                if (intento.equals("")) { // ESTO LO USO PARA QUE LA APLICACION NO SE ME CIERRE AL APRETAR EL CHECK ESTANDO EL EDITTEXT VACIO
                    Toast.makeText(MainActivity.this, "No has escrito ningun numero", Toast.LENGTH_LONG).show();
                } else { // AQUI HAGO TODAS LAS COMPROBACIONES A LA VEZ QUE EDITO LAS VARIABLES DE LA CLASE PLAYER
                    if (Integer.parseInt(intento) > nRandom) {
                        pista = "Intenta un numero mas pequeño";
                        contIntentos = contIntentos + 1;
                        p.setContadorIntentos(contIntentos); // SUMAR CONTADOR Y GUARDAR EN LA VARIABLE
                        //System.out.println(p.getContadorIntentos()); // COMPRUEBO QUE SE GUARDA LA VARIABLE
                        tv.setText("Numero de intentos: " + contIntentos); // MOSTRAR EN EL TV EL NUMERO DE INTENTO QUE LLEVAMOS LEYENDO LA VARIABLE
                        Toast.makeText(MainActivity.this, pista, Toast.LENGTH_LONG).show();
                    } else if (Integer.parseInt(intento) < nRandom) {
                        pista = "Intenta un numero mas grande";
                        contIntentos = contIntentos + 1;
                        p.setContadorIntentos(contIntentos);
                        tv.setText("Numero de intentos: " + contIntentos);
                        Toast.makeText(MainActivity.this, pista, Toast.LENGTH_LONG).show();
                    } else if (Integer.parseInt(intento) == nRandom) {
                        contIntentos = contIntentos + 1;
                        p.setContadorIntentos(contIntentos);
                        tv.setText("Numero de intentos: " + contIntentos);
                        Toast.makeText(MainActivity.this, "Has encontrado el numero", Toast.LENGTH_SHORT).show();

                        openDialog();
                    }
                    introTexto.getText().clear();
                }
            }
        });
    }

    // PARA ABRIR LA SEGUNDA ACTIVITY
    public void openSecondActivity(View view) {
        Intent in = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(in);
    }

    // PARA ABRIR EL DIALOGO
    public void openDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogo);
        dialog.setTitle("Name user");
        dialog.setCancelable(false);
        dialog.show();

        Button buttonRegistro = dialog.findViewById(R.id.botonDialogoD);
        buttonRegistro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText inputDialogo = dialog.findViewById(R.id.record);
                nombreDialogo = inputDialogo.getText().toString();
                p.setContadorIntentos(contIntentos);
                p.setjPlayer(nombreDialogo);
                SecondActivity.listP.add(new Player(nombreDialogo, contIntentos));
                dialog.dismiss();
            }
        });
    }

    // CREO UN METODO RESTART PARA PODER RESETEAR EL NUMERO NRANDOM
    public void restart(View view) {
        contIntentos = 0;
        tv.setText("");
        nRandom = generarRandom();
    }

    //METODO PARA GENERAR UN NUMERO RANDOM
    public static int generarRandom() {
        int numAleatorio = (int) (Math.random() * 100 + 1);
        return numAleatorio;
    }

}
