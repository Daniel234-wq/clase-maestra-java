package com.taller.jefefinal;

public class Personaje {
    protected final String nombre;
    protected int vida;
    protected int ataque;

    public Personaje(String nombre, int vida, int ataque) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
    }

    public final String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public int atacar() {
        return ataque;
    }

    public void recibirDanio(int danio) {
        this.vida = Math.max(0, this.vida - danio);
    }
}
