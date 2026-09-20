package com.taller.nivel5;

import java.util.ArrayList;

public class PracticaPRIMM5 {
    public static void main(String[] args) {
        System.out.println("=== PRACTICA GUIADA PRIMM - NIVEL 5 ===");

        // 1. Predice: Desaparicion tras alfa = null
        Personaje brako = new Personaje("Brako", 120);
        Escuadron alfa = new Escuadron("Alfa");
        alfa.agregar(brako);
        alfa = null;
        System.out.println("1. Despues de alfa = null:");
        System.out.println("   " + brako.getNombre() + " sigue con " + brako.getVida());
        System.out.println("   Brako NO desaparecio porque su referencia sigue viva en la variable 'brako'.");

        // 2. Investiga: Agregacion compartida vs Composicion
        Escuadron beta = new Escuadron("Beta");
        Escuadron gamma = new Escuadron("Gamma");
        beta.agregar(brako);
        gamma.agregar(brako);
        System.out.println("\n2. Cuantos objetos Brako existen al agregarlo a dos escuadrones?");
        System.out.println("   Existe exactamente 1 solo objeto en memoria Heap referenciado por ambos escuadrones.");
        System.out.println("   Si 'agregar' hiciera 'new Personaje(...)' internamente, seria Composicion y serian 2 objetos distintos.");

        // 3. Modifica: agregar como boolean con limite de miembros
        System.out.println("\n3. Agregar 4 miembros con cupo maximo de " + Reglas.MAX_MIEMBROS + ":");
        Escuadron cupo = new Escuadron("EscuadronLimitado");
        System.out.println("   Agregando 1: " + cupo.agregar(new Personaje("H1", 100)));
        System.out.println("   Agregando 2: " + cupo.agregar(new Personaje("H2", 100)));
        System.out.println("   Agregando 3: " + cupo.agregar(new Personaje("H3", 100)));
        System.out.println("   Agregando 4: " + cupo.agregar(new Personaje("H4", 100)) + " (Rechazado por cupo lleno)");

        // Predicciones relámpago
        System.out.println("\n=== PREDICCIONES RELAMPAGO - NIVEL 5 ===");

        // Predicción A
        Personaje k = new Personaje("Kira", 100);
        Escuadron eA = new Escuadron("A");
        Escuadron eB = new Escuadron("B");
        eA.agregar(k);
        eB.agregar(k);
        k.recibirDanio(40);
        int totalVida = eA.vidaTotal() + eB.vidaTotal();
        System.out.println("Prediccion A: Total vida sumada = " + totalVida + " (60 + 60 = 120)");

        // Predicción B
        System.out.println("\nPrediccion B:");
        System.out.println("   'final int monedas = 10; monedas = monedas + 5;' NO COMPILA.");
        System.out.println("   Mensaje: cannot assign a value to final variable monedas.");

        // Predicción C
        final ArrayList<String> botin = new ArrayList<>();
        botin.add("gema");
        botin.add("oro");
        System.out.println("\nPrediccion C: botin.size() = " + botin.size() + " (Esperado: 2).");
        System.out.println("   Explicacion: Una variable de referencia final sella la flecha (no puede apuntar a otra lista),");
        System.out.println("   pero no sella la caja (el objeto interno sigue siendo mutable).");
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

        public String getNombre() {
            return nombre;
        }

        public int getVida() {
            return vida;
        }

        public void recibirDanio(int danio) {
            vida = Math.max(0, vida - danio);
        }
    }

    static class Escuadron {
        private String nombre;
        private ArrayList<Personaje> miembros = new ArrayList<>();

        public Escuadron(String nombre) {
            this.nombre = nombre;
        }

        public boolean agregar(Personaje p) {
            if (miembros.size() >= Reglas.MAX_MIEMBROS) {
                return false;
            }
            miembros.add(p);
            return true;
        }

        public int vidaTotal() {
            int total = 0;
            for (Personaje p : miembros) {
                total += p.getVida();
            }
            return total;
        }
    }
}
