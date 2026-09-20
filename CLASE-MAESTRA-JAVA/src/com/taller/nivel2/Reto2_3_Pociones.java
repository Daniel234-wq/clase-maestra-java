package com.taller.nivel2;

public class Reto2_3_Pociones {
    public static void main(String[] args) {
        System.out.println("=== RETO 2.3: TRES FORMAS DE NACER ===");

        Pocion p1 = new Pocion();
        Pocion p2 = new Pocion(50);
        Pocion p3 = new Pocion("Elixir Ancestral", 120);

        System.out.println("Pocion 1: " + p1.describir());
        System.out.println("Pocion 2: " + p2.describir());
        System.out.println("Pocion 3: " + p3.describir());
    }

    static class Pocion {
        private String nombre;
        private int curacion;

        // Constructor 1: por defecto
        public Pocion() {
            this("Pocion basica", 20);
        }

        // Constructor 2: con curación personalizada
        public Pocion(int curacion) {
            this("Pocion personalizada", curacion);
        }

        // Constructor 3: el único que asigna atributos
        public Pocion(String nombre, int curacion) {
            this.nombre = nombre;
            this.curacion = curacion;
        }

        public String describir() {
            return nombre + " (Cura: " + curacion + " HP)";
        }

        public String getNombre() {
            return nombre;
        }

        public int getCuracion() {
            return curacion;
        }
    }
}
