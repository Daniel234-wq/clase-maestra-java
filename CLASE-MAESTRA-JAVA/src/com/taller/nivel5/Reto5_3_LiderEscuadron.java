package com.taller.nivel5;

import java.util.ArrayList;

public class Reto5_3_LiderEscuadron {
    public static void main(String[] args) {
        System.out.println("=== RETO 5.3 (EXTRA): LIDER DEL ESCUADRON ===");

        Escuadron escuadronVacio = new Escuadron("Vacio");
        System.out.println("1. Probando lider en escuadron vacio:");
        Personaje liderVacio = escuadronVacio.masFuerte();
        if (liderVacio != null) {
            System.out.println("   Lider: " + liderVacio.getNombre());
        } else {
            System.out.println("   El escuadron esta vacio, no hay lider (Retorno seguro: null sin explotar en NullPointerException).");
        }

        System.out.println("\n2. Probando lider en escuadron con 3 miembros:");
        Escuadron escuadronLleno = new Escuadron("Vanguardia");
        escuadronLleno.agregar(new Personaje("Lira", 70));
        escuadronLleno.agregar(new Personaje("Brako", 120));
        escuadronLleno.agregar(new Personaje("Aria", 90));

        Personaje lider = escuadronLleno.masFuerte();
        if (lider != null) {
            System.out.println("   Lider encontrado: " + lider.getNombre() + " con " + lider.getVida() + " HP.");
        }
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

        public Personaje masFuerte() {
            if (miembros.isEmpty()) {
                return null;
            }
            Personaje masFuerte = miembros.get(0);
            for (Personaje p : miembros) {
                if (p.getVida() > masFuerte.getVida()) {
                    masFuerte = p;
                }
            }
            return masFuerte;
        }
    }
}
