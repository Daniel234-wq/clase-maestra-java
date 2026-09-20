package com.taller.nivel5;

import java.util.ArrayList;

public class Reto5_1_MochilaCronista {
    public static void main(String[] args) {
        System.out.println("=== RETO 5.1: LA MOCHILA DEL CRONISTA ===");

        // 4 objetos reales del Cronista
        Objeto cuaderno = new Objeto("Cuaderno de apuntes", 250);
        Objeto termo = new Objeto("Termo de cafe", 450);
        Objeto estuche = new Objeto("Estuche de utiles", 150);
        Objeto libroPesado = new Objeto("Enciclopedia POO", 500);

        Mochila mochila = new Mochila();

        System.out.println("Intentando guardar objetos en mochila (Capacidad maxima: 1000 g):");
        System.out.println("1. Guardar " + cuaderno.getNombre() + " (" + cuaderno.getGramos() + "g): " 
                + mochila.guardar(cuaderno));
        System.out.println("2. Guardar " + termo.getNombre() + " (" + termo.getGramos() + "g): " 
                + mochila.guardar(termo));
        System.out.println("3. Guardar " + estuche.getNombre() + " (" + estuche.getGramos() + "g): " 
                + mochila.guardar(estuche));
        System.out.println("4. Guardar " + libroPesado.getNombre() + " (" + libroPesado.getGramos() + "g): " 
                + mochila.guardar(libroPesado) + " (Rechazado por exceso de peso)");

        System.out.println("\nPeso total en la mochila: " + mochila.pesoTotal() + " g / 1000 g");

        System.out.println("\nDemostracion de agregacion:");
        System.out.println("El objeto '" + libroPesado.getNombre() + "' (" + libroPesado.getGramos() 
                + "g) no cupo en la mochila, pero SIGUE EXISTIENDO independientemente en la mesa.");

        System.out.println("\nExplicacion al docente:");
        System.out.println("Es una relacion de Agregacion ('tiene un') porque la Mochila contiene referencias");
        System.out.println("a objetos que existen por su cuenta en el mundo real antes de entrar en ella,");
        System.out.println("y si la mochila se rompe o se desecha, los objetos siguen existiendo.");
        System.out.println("No es herencia ('es un') porque un libro o un termo no son un tipo de mochila.");
    }

    static class Objeto {
        private final String nombre;
        private final int gramos;

        public Objeto(String nombre, int gramos) {
            this.nombre = nombre;
            this.gramos = gramos;
        }

        public String getNombre() {
            return nombre;
        }

        public int getGramos() {
            return gramos;
        }
    }

    static class Mochila {
        private final int capacidad = 1000; // Capacidad máxima sellada
        private ArrayList<Objeto> objetos = new ArrayList<>();

        public int pesoTotal() {
            int total = 0;
            for (Objeto o : objetos) {
                total += o.getGramos();
            }
            return total;
        }

        public boolean guardar(Objeto o) {
            if (pesoTotal() + o.getGramos() <= capacidad) {
                objetos.add(o);
                return true;
            }
            return false;
        }
    }
}
