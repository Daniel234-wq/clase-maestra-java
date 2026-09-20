package com.taller.nivel5;

import java.util.ArrayList;

public class EjemploBase9 {
    public static void main(String[] args) {
        Personaje brako = new Personaje("Brako", 120);
        Personaje lira = new Personaje("Lira", 70);

        Escuadron alfa = new Escuadron("Alfa");
        alfa.agregar(brako);
        alfa.agregar(lira);
        alfa.mostrar();

        alfa = null; // Se disuelve el escuadrón
        System.out.println(brako.getNombre() + " sigue con " + brako.getVida() + " de vida tras disolver el escuadron.");
    }

    static class Personaje {
        private String nombre;
        private int vida;

        public Personaje(String nombre, int vida) {
            this.nombre = nombre;
            this.vida = vida;
        }

        public String getNombre() {
            return nombre;
        }

        public int getVida() {
            return vida;
        }
    }

    static class Escuadron {
        private String nombre;
        private ArrayList<Personaje> miembros = new ArrayList<>();

        public Escuadron(String nombre) {
            this.nombre = nombre;
        }

        public void agregar(Personaje p) {
            miembros.add(p);
        }

        public int vidaTotal() {
            int total = 0;
            for (Personaje p : miembros) {
                total = total + p.getVida();
            }
            return total;
        }

        public void mostrar() {
            System.out.println("Escuadron " + nombre + ": " + miembros.size() 
                    + " miembros, vida " + vidaTotal());
            for (Personaje p : miembros) {
                System.out.println("  - " + p.getNombre());
            }
        }
    }
}
