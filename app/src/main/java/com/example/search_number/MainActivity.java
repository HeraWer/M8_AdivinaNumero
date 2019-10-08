package com.example.search_number;

import androidx.appcompat.app.AppCompatActivity;

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

    private Player p = new Player();
    private Dialogo d = new Dialogo();
    private int nRandom = generarRandom(); // VARIABLE PARA GENERAR UN RANDOM
    private TextView tv; // VARIABLE PARA CREAR UN TEXTVIEW DONDE SE VERAN LOS INTENTOS
    private EditText introTexto; // VARIABLE PARA LEER LO QUE INTRODUCIMOS EN EL EDITTEXT DE INTENTOS
    private ArrayList<Player> listP = new ArrayList<>();

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
                        p.setContadorIntentos(p.getContadorIntentos() + 1); // SUMAR CONTADOR Y GUARDAR EN LA VARIABLE
                        //System.out.println(p.getContadorIntentos()); // COMPRUEBO QUE SE GUARDA LA VARIABLE
                        tv.setText("Numero de intentos: " + p.getContadorIntentos()); // MOSTRAR EN EL TV EL NUMERO DE INTENTO QUE LLEVAMOS LEYENDO LA VARIABLE
                        Toast.makeText(MainActivity.this, pista, Toast.LENGTH_LONG).show();
                    } else if (Integer.parseInt(intento) < nRandom) {
                        pista = "Intenta un numero mas grande";
                        p.setContadorIntentos(p.getContadorIntentos() + 1);
                        tv.setText("Numero de intentos: " + p.getContadorIntentos());
                        Toast.makeText(MainActivity.this, pista, Toast.LENGTH_LONG).show();
                    } else if (Integer.parseInt(intento) == nRandom) {
                        p.setContadorIntentos(p.getContadorIntentos() + 1);
                        Toast.makeText(MainActivity.this, "Has encontrado el numero", Toast.LENGTH_SHORT).show();
                        openDialog();

                        /*p.setjPlayer(d.getNom());
                        listP.add(new Player(p.getjPlayer(), p.getContadorIntentos()));
                        for (Object obj : listP) {
                            System.out.println(obj.toString());
                        }*/
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
        Dialogo d = new Dialogo();
        d.show(getSupportFragmentManager(), "Para el raking");
        /*restart();*/ // SI PONGO LA LLAMADA AL METODO Y QUITO EL VIEW VIEW SE PUEDE RESETEAR DESDE EL DIALOGO SIN NECESIDAD DE TENER UN BOTON VOLVER A EMPEZAR
    }
    // CREO UN METODO RESTART PARA PODER RESETEAR EL NUMERO NRANDOM
    public void restart(View view){
        p.setContadorIntentos(0);
        tv.setText("");
        nRandom = generarRandom();
    }

    //METODO PARA GENERAR UN NUMERO RANDOM
    public static int generarRandom(){
        int numAleatorio = (int) (Math.random() * 100 + 1);
        return numAleatorio;
    }

}
