package com.taller.jefefinal;

public class Arquero extends Personaje {
    private int precision;

    public Arquero(String nombre, int vida, int ataque, int precision) {
        super(nombre, vida, ataque);
        this.precision = precision;
    }

    @Override
    public int atacar() {
        return ataque + precision;
    }

    public int getPrecision() {
        return precision;
    }
}
