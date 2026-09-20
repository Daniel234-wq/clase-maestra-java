package com.taller.jefefinal;

public class Guerrero extends Personaje {
    private int armadura;

    public Guerrero(String nombre, int vida, int ataque, int armadura) {
        super(nombre, vida, ataque);
        this.armadura = armadura;
    }

    @Override
    public int atacar() {
        return ataque + 5;
    }

    @Override
    public void recibirDanio(int golpe) {
        int danioReducido = Math.max(0, golpe - armadura);
        super.recibirDanio(danioReducido);
    }

    public int getArmadura() {
        return armadura;
    }
}
