package com.taller.jefefinal;

public class Mago extends Personaje {
    public Mago(String nombre, int vida, int ataque) {
        super(nombre, vida, ataque);
    }

    @Override
    public int atacar() {
        return ataque * 2;
    }
}
