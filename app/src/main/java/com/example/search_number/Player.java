package com.example.search_number;



public class Player implements Comparable<Player>{

    private String jPlayer = new String();
    private int contadorIntentos = 0;


    // SETTERS Y GETTERS
    public int getContadorIntentos() {
        return contadorIntentos;
    }

    public void setContadorIntentos(int contadorIntentos) {
        this.contadorIntentos = contadorIntentos;
    }

    public String getjPlayer() {
        return jPlayer;
    }

    public void setjPlayer(String jPlayer) {

        this.jPlayer = jPlayer;
    }

    public Player(){

    }

    // CONSTRUCTOR
    public Player(String jPlayer, int contadorIntentos) {
        this.jPlayer = jPlayer;
        this.contadorIntentos = contadorIntentos;
    }

    //METODO PARA IMPRIMIR LA LISTA Y QUE EL CONTENIDO SEA VISIBLE
    @Override
    public String toString() {
        return  jPlayer + "                                                      " + contadorIntentos;
    }

    // METODO PARA ORDENAR LA LISTA DE OBJETOS POR CONTADORINTENTOS ( EL COLLECTIONS )
    @Override
    public int compareTo(Player o) {
        if (contadorIntentos < o.contadorIntentos){
            return -1;
        }
        if (contadorIntentos > o.contadorIntentos){
            return 1;
        }
        return 0;
    }


}
