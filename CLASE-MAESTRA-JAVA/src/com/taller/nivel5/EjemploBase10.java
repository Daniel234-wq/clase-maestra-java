package com.taller.nivel5;

public class EjemploBase10 {
    public static void main(String[] args) {
        Personaje kira = new Personaje("Kira", 200);
        System.out.println(kira.getNombre() + ": " + kira.getVida());
        System.out.println("Maximo permitido por las reglas: " + Reglas.VIDA_MAXIMA);
    }

    final static class Reglas {
        public static final int VIDA_MAXIMA = 150;
        public static final int MAX_MIEMBROS = 3;
    }

    static class Personaje {
        private final String nombre; // Inmutable tras el constructor
        private int vida;

        public Personaje(String nombre, int vida) {
            this.nombre = nombre;
            this.vida = Math.min(vida, Reglas.VIDA_MAXIMA);
        }

        public final String getNombre() { // Sellado: ninguna subclase puede sobrescribirlo
            return nombre;
        }

        public int getVida() {
            return vida;
        }
    }
}
