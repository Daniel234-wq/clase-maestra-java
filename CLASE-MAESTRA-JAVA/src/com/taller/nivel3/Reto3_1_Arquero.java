package com.taller.nivel3;

public class Reto3_1_Arquero {
    public static void main(String[] args) {
        System.out.println("=== RETO 3.1: NACE EL ARQUERO ===");
        Arquero robin = new Arquero("Robin", 90, 12, 2);

        robin.presentarse();
        System.out.println("Realizando 3 disparos con 2 flechas iniciales:");
        robin.disparar();
        robin.disparar();
        robin.disparar();
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

        public void presentarse() {
            System.out.println(nombre + " | vida " + vida + " | ataque " + ataque);
        }
    }

    static class Arquero extends Personaje {
        private int flechas;

        public Arquero(String nombre, int vida, int ataque, int flechas) {
            super(nombre, vida, ataque);
            this.flechas = flechas;
        }

        public void disparar() {
            if (flechas > 0) {
                flechas--;
                System.out.println(nombre + " dispara una flecha certera. Quedan: " + flechas + " flechas.");
            } else {
                System.out.println(nombre + " intenta disparar, pero no le quedan flechas en el carcaj!");
            }
        }

        public int getFlechas() {
            return flechas;
        }
    }
}
