package com.example.search_number;



public class Player {

    private String jPlayer = new String();
    private int contadorIntentos = 0;

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

    public Player(String jPlayer, int contadorIntentos) {
        this.jPlayer = jPlayer;
        this.contadorIntentos = contadorIntentos;
    }
}
