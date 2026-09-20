package com.taller.nivel1;

public class EjemploBase2 {
    public static void main(String[] args) {
        Heroe kira = new Heroe();
        kira.nombre = "Kira";
        kira.vida = 100;
        kira.ataque = 12;

        kira.recibirDanio(30);
        System.out.println("Vida restante: " + kira.vida);
        System.out.println("Golpe critico: " + kira.golpeCritico());
        System.out.println("Esta vivo: " + kira.estaVivo());
    }

    static class Heroe {
        String nombre;
        int vida;
        int ataque;

        void recibirDanio(int danio) {
            vida = vida - danio;
        }

        boolean estaVivo() {
            return vida > 0;
        }

        int golpeCritico() {
            return ataque * 2;
        }
    }
}
