package com.example.tnb_20.numericos;

public class Jugador implements Comparable<Jugador> {
    private String name;
    private int intentos;

    public Jugador(String name, int intentos) {
        this.name = name;
        this.intentos = intentos;
    }

    public String getName() {
        return name;
    }

    public int getIntentos() {
        return intentos;
    }

    @Override
    public String toString() {
        return "Jugador{" + "name='" + name + '\'' + ", Intentos=" + intentos + '}';
    }

    @Override
    public int compareTo(Jugador j){
        return this.intentos - j.intentos;
    }

}