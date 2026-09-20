package com.taller.jefefinal;

public final class Dragon extends Personaje {
    public Dragon() {
        super("Dragon Null", 330, 35);
    }

    // Sobrecarga de atacar con el numero de ronda
    public int atacar(int ronda) {
        if (ronda % 3 == 0) {
            return ataque * 2; // Golpe critico cada 3 rondas (70 de danio)
        }
        return ataque; // Golpe normal (35 de danio)
    }
}
