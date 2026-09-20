package com.taller.nivel4;

public class EjemploBase7 {
    public static void main(String[] args) {
        Personaje[] arena = {
            new Guerrero("Brako", 120, 15),
            new Mago("Lira", 70, 12),
            new Personaje("Aldeano", 40, 3)
        };

        int total = 0;
        for (Personaje p : arena) {
            int danio = p.atacar();
            System.out.println(p.getNombre() + " hace " + danio + " de danio");
            total = total + danio;
        }
        System.out.println("Danio total: " + total);
    }

    static class Personaje {
        protected String nombre;
        protected int vida;
        protected int ataque;

        public Personaje(String nombre, int vida, int ataque) {
            this.nombre = nombre;
            this.vida = vida;
            this.ataque = ataque;
        }

        public String getNombre() {
            return nombre;
        }

        public int atacar() {
            return ataque;
        }
    }

    static class Guerrero extends Personaje {
        public Guerrero(String nombre, int vida, int ataque) {
            super(nombre, vida, ataque);
        }

        @Override
        public int atacar() {
            return ataque + 5;
        }
    }

    static class Mago extends Personaje {
        public Mago(String nombre, int vida, int ataque) {
            super(nombre, vida, ataque);
        }

        @Override
        public int atacar() {
            return ataque * 2;
        }

        public void lanzarHechizo() {
            System.out.println(nombre + " lanza un rayo");
        }
    }
}
