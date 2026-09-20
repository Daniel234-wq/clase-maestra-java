package com.taller.nivel2;

public class EjemploBase3 {
    public static void main(String[] args) {
        Heroe kira = new Heroe("Kira", 100, 12);
        Heroe pip = new Heroe("Pip");

        kira.saludar();
        pip.saludar();
    }

    static class Heroe {
        String nombre;
        int vida;
        int ataque;

        Heroe(String nombre, int vida, int ataque) {
            this.nombre = nombre;
            this.vida = vida;
            this.ataque = ataque;
        }

        Heroe(String nombre) {
            this(nombre, 100, 10);
        }

        void saludar() {
            System.out.println(nombre + ": vida " + vida + ", ataque " + ataque);
        }
    }
}
