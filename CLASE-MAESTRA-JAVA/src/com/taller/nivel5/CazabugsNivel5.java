package com.taller.nivel5;

import java.util.ArrayList;

public class CazabugsNivel5 {
    public static void main(String[] args) {
        System.out.println("=== CAZABUGS - NIVEL 5 ===");
        System.out.println("Bug 1 (Linea 5 original): 'private ArrayList<Personaje> miembros;' no estaba inicializada (null).");
        System.out.println("      Al invocar miembros.size() en agregar(), lanzaba NullPointerException al ejecutar.");
        System.out.println("      Correccion: Inicializar con '= new ArrayList<>();'.");
        System.out.println("Bug 2 (Linea 8 original): 'if (miembros.size() > Reglas.MAX_MIEMBROS)'.");
        System.out.println("      Al tener 3 miembros, '3 > 3' es false y dejaba entrar al 4to miembro.");
        System.out.println("      Correccion: Cambiar la condicion a '>= Reglas.MAX_MIEMBROS'.\n");

        Escuadron e = new Escuadron();
        System.out.println("Agregando A: " + e.agregar(new Personaje("A", 10)));
        System.out.println("Agregando B: " + e.agregar(new Personaje("B", 10)));
        System.out.println("Agregando C: " + e.agregar(new Personaje("C", 10)));
        System.out.println("Agregando D: " + e.agregar(new Personaje("D", 10)));
        System.out.println("Salida esperada y obtenida: true, true, true, false");
    }

    final static class Reglas {
        public static final int MAX_MIEMBROS = 3;
    }

    static class Personaje {
        private String nombre;
        private int vida;

        public Personaje(String nombre, int vida) {
            this.nombre = nombre;
            this.vida = vida;
        }
    }

    static class Escuadron {
        // Corrección Bug 1: inicialización de la lista
        private ArrayList<Personaje> miembros = new ArrayList<>();

        public boolean agregar(Personaje p) {
            // Corrección Bug 2: validación estricta de cupo con >=
            if (miembros.size() >= Reglas.MAX_MIEMBROS) {
                return false;
            }
            miembros.add(p);
            return true;
        }
    }
}
